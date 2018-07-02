package com.okawa.minichat.ui.confirmation

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.okawa.minichat.R
import com.okawa.minichat.base.BaseDialog
import com.okawa.minichat.databinding.DialogConfirmationBinding
import javax.inject.Inject

class ConfirmationDialog : BaseDialog<DialogConfirmationBinding, ConfirmationViewModel>() {

    companion object {
        private const val MESSAGE_ID_PARAM = "message_id"

        fun newInstance(messageId: Long): ConfirmationDialog {
            val dialog = ConfirmationDialog()
            val arguments = Bundle()
            arguments.putLong(MESSAGE_ID_PARAM, messageId)
            dialog.arguments = arguments
            return dialog
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun layoutToInflate() = R.layout.dialog_confirmation

    override fun defineViewModel() =
            ViewModelProviders.of(this, viewModelFactory).get(ConfirmationViewModel::class.java)

    override fun doOnCreated() {
        val messageId = arguments?.getLong(MESSAGE_ID_PARAM)

        dataBinding.setOnClickListener { view ->
            when(view.id) {
                R.id.btnConfirmationNo -> dismiss()
                R.id.btnConfirmationYes -> {
                    viewModel.deleteMessage(messageId)
                    dismiss()
                }
            }
        }
    }
}