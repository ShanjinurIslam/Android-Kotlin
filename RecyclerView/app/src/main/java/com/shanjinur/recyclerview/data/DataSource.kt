package com.shanjinur.recyclerview.data

import com.shanjinur.recyclerview.R
import com.shanjinur.recyclerview.model.Affirmation

class DataSource {
    companion object {
        fun loadAffirmations(): List<Affirmation> {
            return listOf<Affirmation>(
                Affirmation(R.string.affirmation1),
                Affirmation(R.string.affirmation2),
                Affirmation(R.string.affirmation3),
                Affirmation(R.string.affirmation4),
                Affirmation(R.string.affirmation5),
                Affirmation(R.string.affirmation6),
                Affirmation(R.string.affirmation7),
                Affirmation(R.string.affirmation8),
                Affirmation(R.string.affirmation9),
                Affirmation(R.string.affirmation10)
            )
        }
    }
}