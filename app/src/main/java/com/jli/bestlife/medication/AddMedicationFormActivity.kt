package com.jli.bestlife.medication

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.jli.bestlife.MedicationStore
import com.jli.bestlife.R
import com.jli.bestlife.domain.Drug
import com.jli.bestlife.domain.UserMedication
import kotlinx.android.synthetic.main.activity_medication_form.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import java.util.*


class AddMedicationFormActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, KodeinAware {

    override val kodein: Kodein by closestKodein()
    lateinit var drug: Drug

    private val medicationStore: MedicationStore by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medication_form)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drug = intent.extras.getSerializable(DRUG_ARG) as Drug
        supportActionBar?.title = drug.brandName

        val spinner: Spinner = findViewById(R.id.frequency_spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.frequency_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        refill_reminder.setOnClickListener {
            val myCalendar = Calendar.getInstance()
            val date = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, monthOfYear)
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            }
            val dialog = DatePickerDialog(
                this,
                this,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            )
            dialog.show()
        }

        generic_name_label.text = "Medication: ".plus(drug.genericName)
        active_ingredient_label.text = "Active Ingredients: ".plus(drug.activeIngredient)
        dosage_label.text = "Instructions: ".plus(drug.dosageInstruction)
        warning_label.text = "Warning: ".plus(drug.askDoctorWarning)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val format = String.format("%d-%d-%d", month, dayOfMonth, year)
        refill_reminder.setText(format)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.save_medication -> {
                saveMedication()
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveMedication() {
        val userMed = UserMedication(
            drug, dosage.text.toString(),
            frequency_spinner.selectedItem.toString(),
            refill_reminder.text.toString()
        )
        medicationStore.addMedication(userMed)
    }

    companion object {
        val DRUG_ARG = AddMedicationFormActivity.javaClass.name.plus("DRUG_ARG")

        fun start(context: Context, drug: Drug) {
            val intent = Intent(context, AddMedicationFormActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(DRUG_ARG, drug)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }
}
