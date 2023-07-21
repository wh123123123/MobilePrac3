package my.edu.tarc.mobileprac3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.mobileprac3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding       //reverse of class name:  class = SecondActivity, bind name = ActivitySecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //show the UI
        binding = ActivityMainBinding.inflate(layoutInflater)
        //binding = UI tree
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener{
            var total = 0
            val age = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked

            when (age) {
                0 -> { //Less than 17
                    total = 60

                }
                1 -> {// 17 to 25
                    total = 70

                }
                2 -> {//26 to 30
                    total = 90

                }
                3 -> {//31 to 40
                    total = 120

                }
                4 -> {//41 to 55
                    total = 150

                }
                else -> {//More than 55
                    total = 150
                }
            }

            if (gender == binding.radioButtonMale.id){
                when (age) {
                    0 -> { //Less than 17
                        total = total

                    }
                    1 -> {// 17 to 25
                        total += 50

                    }
                    2 -> {//26 to 30
                        total += 100

                    }
                    3 -> {//31 to 40
                        total += 150

                    }
                    4 -> {//41 to 55
                        total += 200

                    }
                    else -> {//More than 55
                        total += 200
                    }
                }
            }else{
                total = total
            }

            if(smoker){
                when (age) {
                    0 -> { //Less than 17
                        total = total

                    }
                    1 -> {// 17 to 25
                        total += 100

                    }
                    2 -> {//26 to 30
                        total += 150

                    }
                    3 -> {//31 to 40
                        total += 200

                    }
                    4 -> {//41 to 55
                        total += 250

                    }
                    else -> {//More than 55
                        total += 300
                    }
                }
            }else{
                total = total
            }

            binding.textViewPremium.text = total.toString()

        }

        binding.buttonReset.setOnClickListener {
            binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.setChecked(false)
            binding.textViewPremium.setText("No value")
        }




    }
}