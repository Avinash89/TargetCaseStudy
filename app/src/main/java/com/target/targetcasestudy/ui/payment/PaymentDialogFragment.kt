package com.target.targetcasestudy.ui.payment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.target.targetcasestudy.R
import com.target.targetcasestudy.util.CardValidator


/**
 * Dialog that displays a minimal credit card entry form.
 *
 * Your task here is to enable the "submit" button when the credit card number is valid and
 * disable the button when the credit card number is not valid.
 *
 * You do not need to input any of your actual credit card information. See `Validators.kt` for
 * info to help you get fake credit card numbers.
 *
 * You do not need to make any changes to the layout of this screen (though you are welcome to do
 * so if you wish).
 */
class PaymentDialogFragment : DialogFragment() {

    private lateinit var submitButton: Button
    private var lValidator: CardValidator = CardValidator()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.dialog_payment, container, false)

        submitButton = root.findViewById(R.id.submit)
        submitButton.isEnabled = false

        var creditCardInput: EditText = root.findViewById(R.id.card_number)
        val cancelButton: Button = root.findViewById(R.id.cancel)

        cancelButton.setOnClickListener { dismiss() }
        submitButton.setOnClickListener { dismiss() }

        // TODO enable the submit button based on card number validity using Validators.validateCreditCard()

        var ccNumber = ""
        val ccWatcher: TextWatcher = object : TextWatcher {
            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
            }

            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
                if (ccNumber.length < s.length) {
                    when (s.length) {
                        5 -> s.insert(4, " ")
                        10 -> s.insert(9, " ")
                        15 -> s.insert(14, " ")
                    }
                }
                ccNumber = s.toString()
                if (ccNumber.length >= 16) {
                    if (lValidator.isValid(ccNumber)) {
                        submitButton.isEnabled = true
                    } else {
                        submitButton.isEnabled = false
                    }
                } else {
                    submitButton.isEnabled = false
                }
            }
        }

        creditCardInput.addTextChangedListener(ccWatcher)

        return root
    }

}