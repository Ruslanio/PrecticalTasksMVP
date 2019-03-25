package com.example.practicaltasksmvp.mvp.presenter.fragment

import com.arellomobile.mvp.InjectViewState
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.data.local.realm.entity.Friend
import com.example.practicaltasksmvp.mvp.base.BasePresenter
import com.example.practicaltasksmvp.mvp.view.fragment.ProfileView
import com.example.practicaltasksmvp.util.EditProfileDialog

@InjectViewState
class ProfilePresenter() :
    BasePresenter<ProfileView>() {

    val dialogListener = object : EditProfileDialog.OnEditDialogClickListener {
        override fun onChooseClick() {
            viewState.showToast("UPLOAD")
        }

        override fun onDeleteClick() {
            viewState.showToast("DELETE")
        }

        override fun onTakeClick() {
            viewState.showToast("SHOOT")
        }
    }

    fun prepareTestData(): List<Friend> {
        val testData = ArrayList<Friend>()
        val kons = Friend()
        with(kons) {
            id = 0
            firstName = "Константин"
            secondName = "Хабенский"
            avatarIconRes = R.drawable.avatar_1
        }
        testData.add(kons)

        val alex = Friend()
        with(alex) {
            id = 1
            firstName = "Александр"
            secondName = "Романов"
            avatarIconRes = R.drawable.avatar_2
        }
        testData.add(alex)

        val paw = Friend()
        with(paw) {
            id = 2
            firstName = "Павел"
            secondName = "Романов"
            avatarIconRes = R.drawable.avatar_3
        }
        testData.add(paw)
        return testData
    }

    fun showFragment(forceShow : Boolean) {
        viewState.showFragment(dialogListener, forceShow)
    }
}