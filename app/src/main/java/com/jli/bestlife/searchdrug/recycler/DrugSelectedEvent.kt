package com.jli.bestlife.searchdrug.recycler

import com.jli.bestlife.domain.Drug
import com.jli.bestlife.view.BaseInputEvent

class DrugSelectedEvent(val drug: Drug) : BaseInputEvent()