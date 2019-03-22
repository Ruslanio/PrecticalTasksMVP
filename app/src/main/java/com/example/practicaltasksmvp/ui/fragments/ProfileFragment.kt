package com.example.practicaltasksmvp.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.practicaltasksmvp.R
import com.example.practicaltasksmvp.data.local.realm.entity.Friend
import com.example.practicaltasksmvp.mvp.base.BaseFragment
import com.example.practicaltasksmvp.mvp.presenter.fragment.ProfilePresenter
import com.example.practicaltasksmvp.mvp.view.fragment.ProfileView
import com.example.practicaltasksmvp.util.EditProfileDialog
import com.example.practicaltasksmvp.util.setUp
import dagger.Lazy
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.item_friend.view.*
import javax.inject.Inject

class ProfileFragment : BaseFragment<ProfileView, ProfilePresenter>(), ProfileView {
    companion object {

        private const val TAG_DIALOG = "tag_dialog"
    }

    @ProvidePresenter
    override fun providePresenter(): ProfilePresenter = daggerPresenter.get()

    @InjectPresenter
    override lateinit var presenter: ProfilePresenter

    @Inject
    override lateinit var daggerPresenter: Lazy<ProfilePresenter>


    @SuppressLint("SetTextI18n")
    override fun onInit(savedInstanceState: Bundle?) {
        view?.rvUserFriends?.setUp(presenter.prepareTestData() as MutableList<Friend>
            , R.layout.item_friend, {
                tvName.text = "${it.firstName} ${it.secondName}"
                ivAvatar.setImageResource(it.avatarIconRes)
            })

        presenter.showFragment(false)

        view?.ivProfilePicture?.setOnClickListener {
            presenter.showFragment(true)
        }
    }


    override fun showToast(msg: String) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }


    override fun showFragment(listener: EditProfileDialog.OnEditDialogClickListener, forceShow: Boolean) {
        val transaction = fragmentManager!!.beginTransaction()
        val previous = fragmentManager!!.findFragmentByTag(TAG_DIALOG)
        if (previous == null) {
            if (forceShow) {
                initAndShowFragment(transaction, listener)
            }
        } else {
            transaction.remove(previous)
            initAndShowFragment(transaction, listener)

        }
    }

    private fun initAndShowFragment(
        transaction: FragmentTransaction,
        listener: EditProfileDialog.OnEditDialogClickListener
    ) {
        val dialogFragment = EditProfileDialog.newInstance(listener)
        dialogFragment.show(transaction, TAG_DIALOG)
    }

    override fun layoutId(): Int {
        return R.layout.fragment_profile
    }
}