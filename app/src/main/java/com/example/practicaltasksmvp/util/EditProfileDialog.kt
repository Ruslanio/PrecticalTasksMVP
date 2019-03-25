package com.example.practicaltasksmvp.util

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.practicaltasksmvp.R

class EditProfileDialog : DialogFragment() {

    var listener: OnEditDialogClickListener? = null

    companion object {
        fun newInstance(listener: OnEditDialogClickListener): EditProfileDialog {
            val fragment = EditProfileDialog()
            fragment.listener = listener
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_edit_profile, container, false)

        view?.findViewById<View>(R.id.containerChoose)?.setOnClickListener {
            listener?.onChooseClick()
            dismiss()
        }
        view?.findViewById<View>(R.id.containerDelete)?.setOnClickListener {
            listener?.onDeleteClick()
            dismiss()
        }
        view?.findViewById<View>(R.id.containerTake)?.setOnClickListener {
            listener?.onTakeClick()
            dismiss()
        }

        return view
    }

    interface OnEditDialogClickListener {
        fun onChooseClick()
        fun onDeleteClick()
        fun onTakeClick()
    }
}