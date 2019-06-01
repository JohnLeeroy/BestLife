package com.jli.bestlife.medication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.jli.bestlife.R
import com.jli.bestlife.domain.Drug

class AddMedicationFormActivity : AppCompatActivity() {

    lateinit var drug: Drug

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medication_form)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drug = intent.extras.getSerializable(DRUG_ARG) as Drug
        supportActionBar?.title = drug.brandName
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.save_medication -> {

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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
