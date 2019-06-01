package com.jli.bestlife.searchdrug.recycler

import com.jli.bestlife.domain.UserMedication
import com.jli.bestlife.view.BaseInputEvent

class MedicationSelectedEvent(val userMedication: UserMedication) : BaseInputEvent()