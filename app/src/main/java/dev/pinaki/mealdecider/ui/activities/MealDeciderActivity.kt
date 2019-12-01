package dev.pinaki.mealdecider.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import dev.pinaki.mealdecider.R
import dev.pinaki.mealdecider.databinding.MealsDeciderBinding
import dev.pinaki.mealdecider.ui.bottomsheets.SingleChoiceBottomSheetDialogFragment
import dev.pinaki.mealdecider.ui.bottomsheets.SingleChoiceBottomSheetItem

/*
*TODO:
* 1. Make the view model layer
* 2. Implement dagger
* 3. Complete repository code
* 4.
 */
class MealDeciderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<MealsDeciderBinding>(
            this,
            R.layout.layout_meal_decider
        )
        setSupportActionBar(binding.bottomAppBar)

        binding.bottomAppBar.setNavigationOnClickListener {
            val testList: ArrayList<SingleChoiceBottomSheetItem> = ArrayList()
            testList.add(SingleChoiceBottomSheetItem(0, "Lunch", false))
            testList.add(SingleChoiceBottomSheetItem(1, "Breakfast", false))
            testList.add(SingleChoiceBottomSheetItem(2, "Brunch", false))
            testList.add(SingleChoiceBottomSheetItem(3, "Evening Snacks", false))
            testList.add(SingleChoiceBottomSheetItem(4, "Cheat Diet", true))
            testList.add(SingleChoiceBottomSheetItem(4, "Dinner", false))
            testList.add(SingleChoiceBottomSheetItem(4, "Pre Gym Snacks", false))
            testList.add(SingleChoiceBottomSheetItem(4, "Post Gym Snacks", false))

            SingleChoiceBottomSheetDialogFragment.getInstance(
                "Select a Meal Category",
                testList
            ).show(
                supportFragmentManager,
                SingleChoiceBottomSheetDialogFragment.TAG
            )
        }
    }
}
