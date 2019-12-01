package dev.pinaki.mealdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import dev.pinaki.mealdecider.databinding.MealsDeciderBinding

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<MealsDeciderBinding>(this, R.layout.layout_meal_decider)
        setSupportActionBar(binding.bottomAppBar)

        binding.bottomAppBar.setNavigationOnClickListener {
            //TODO: show a bottom sheet
        }
    }
}
