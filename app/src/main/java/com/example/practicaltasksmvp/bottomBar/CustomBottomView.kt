package com.example.practicaltasks.views.bottomBar

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity.BOTTOM
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.practicaltasksmvp.R

import com.google.android.material.floatingactionbutton.FloatingActionButton


class CustomBottomView @JvmOverloads constructor(context: Context,
                                                 attrs: AttributeSet? = null,
                                                 defStyleAttr: Int = 0)
    : RelativeLayout(context, attrs, defStyleAttr) {

    companion object {
        private const val NOT_DEFINED = Int.MIN_VALUE
        private const val MAX_SPACE_ITEM_NUM = 4
        private const val MIN_SPACE_ITEM_NUM = 2
        private const val LABEL_ID = 777
        private const val CURRENT_SELECTED_ITEM_BUNDLE_KEY = "currentItem"
        private const val CENTRE_BUTTON_INDEX = -1

    }

    private var mainColor: Int
    private var accentColor: Int
    private var labelColor: Int
    private var accentButtonPadding: Float

    private var labelSize: Float
    private var accentButtonImage: Drawable
    private var accentButtonImageColor: Int

    private var labelText: String

    private var spaceItems = ArrayList<SpaceItem>()
    private val spaceItemList = ArrayList<View>()

    private var contentWidth: Int = 0
    private var accentButtonSize: Int = resources.getDimension(R.dimen.design_fab_size_normal).toInt()

    private lateinit var accentButton: FloatingActionButton
    private lateinit var leftContent: LinearLayout
    private lateinit var rightContent: LinearLayout
    private lateinit var centreBackgroundView: RelativeLayout
    private lateinit var centreContent: CenterCircle

    private var spaceNavigationHeight: Int = resources.getDimension(R.dimen.space_navigation_height).toInt()
    private var mainContentHeight: Int = resources.getDimension(R.dimen.main_content_height).toInt()
    private var centreContentWight: Int = resources.getDimension(R.dimen.centre_content_width).toInt()

    private var accentColorPressed: Int = ContextCompat.getColor(context, R.color.light_accent)

    var onClickBottomViewListener: OnClickListener? = null

    private var currentSelectedItem: Int = NOT_DEFINED
    private var activeSpaceItemColor: Int = ContextCompat.getColor(context, R.color.colorPrimary)
    private var inActiveSpaceItemColor: Int = ContextCompat.getColor(context, R.color.black_40)


    init {

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomBottomView)
        try {
            mainColor = typedArray.getColor(R.styleable.CustomBottomView_backgroundColor, resources.getColor(R.color.white))
            accentColor = typedArray.getColor(R.styleable.CustomBottomView_accentColor, resources.getColor(R.color.colorAccent))
            accentButtonPadding = typedArray.getDimension(R.styleable.CustomBottomView_accentButtonPadding, resources.getDimension(R.dimen.small_padding))
            labelText = typedArray.getString(R.styleable.CustomBottomView_label)
            labelColor = typedArray.getColor(R.styleable.CustomBottomView_labelsColor, resources.getColor(R.color.black_40))
            labelSize = typedArray.getDimension(R.styleable.CustomBottomView_labelSize, resources.getDimension(R.dimen.small_text_size))
            val imageResId = typedArray.getResourceId(R.styleable.CustomBottomView_accentButtonImage, R.drawable.ic_heart)
            accentButtonImage = ContextCompat.getDrawable(context, imageResId)!!
            accentButtonImageColor = typedArray.getColor(R.styleable.CustomBottomView_accentButtonImageColor, ContextCompat.getColor(context, R.color.white))

        } finally {
            typedArray.recycle()
        }

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val params = layoutParams
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = spaceNavigationHeight
        setBackgroundColor(ContextCompat.getColor(context, R.color.transparent))
        layoutParams = params
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        if (spaceItems.size < MIN_SPACE_ITEM_NUM || spaceItems.size > MAX_SPACE_ITEM_NUM) {
            throw InvalidNumberOfItemsException("Number of items must in range 2..4, yours number : ${spaceItems.size}")
        }

        contentWidth = (width - spaceNavigationHeight) / 2

        removeAllViews()
        initAndAddViewsToMainView()
        postRequestLayout()
    }

    private fun initAndAddViewsToMainView() {
        val mainContent = RelativeLayout(context)
        centreBackgroundView = RelativeLayout(context)
        centreContent = buildCenterCircle(mainColor, (accentButtonSize + resources.getDimension(R.dimen.medium_padding)).toInt())

        leftContent = LinearLayout(context)
        rightContent = LinearLayout(context)

        val label = TextView(context)
        label.text = labelText
        label.setTextSize(TypedValue.COMPLEX_UNIT_PX, labelSize)
        label.id = LABEL_ID
        label.setTextColor(labelColor)

        accentButton = FloatingActionButton(context)
        accentButton.backgroundTintList = ColorStateList.valueOf(accentColor)
        accentButton.size = FloatingActionButton.SIZE_AUTO
        accentButton.useCompatPadding = false
        accentButton.setImageDrawable(accentButtonImage)
        accentButton.elevation = 0f
        accentButton.compatElevation = 0f

        accentButton.setOnClickListener {
            onClickBottomViewListener?.onCentreButtonClick()
            updateSpaceItems(CENTRE_BUTTON_INDEX)
        }

        val labelParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        labelParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        labelParams.addRule(RelativeLayout.CENTER_HORIZONTAL)

        val accentButtonParams = LayoutParams(accentButtonSize, accentButtonSize)
        accentButtonParams.addRule(RelativeLayout.CENTER_IN_PARENT)

        val mainParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, spaceNavigationHeight)
        mainParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)

        /**
         * Centre content size
         */
        val centreContentParams = RelativeLayout.LayoutParams(centreContentWight, spaceNavigationHeight)
        centreContentParams.addRule(RelativeLayout.CENTER_HORIZONTAL)
        centreContentParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        centreContentParams.addRule(RelativeLayout.ABOVE, LABEL_ID)

        /**
         * Centre Background View content size and position
         */
        val centreBackgroundViewParams = RelativeLayout.LayoutParams(centreContentWight, mainContentHeight)
        centreBackgroundViewParams.addRule(RelativeLayout.CENTER_HORIZONTAL)
        centreBackgroundViewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)

        /**
         * Left content size
         */
        val leftContentParams = RelativeLayout.LayoutParams(contentWidth, mainContentHeight)
        leftContentParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT)
        leftContentParams.addRule(LinearLayout.HORIZONTAL)
        leftContentParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)

        /**
         * Right content size
         */
        val rightContentParams = RelativeLayout.LayoutParams(contentWidth, mainContentHeight)
        rightContentParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
        rightContentParams.addRule(LinearLayout.HORIZONTAL)
        rightContentParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)

        /**
         * Adding views background colors
         */
        setBackgroundColors()

        /**
         * Adding view to centreContent
         */
        centreContent.addView(accentButton, accentButtonParams)

        /**
         * Adding views to mainContent
         */
        mainContent.addView(leftContent, leftContentParams)
        mainContent.addView(rightContent, rightContentParams)

        mainContent.addView(label, labelParams)
        mainContent.addView(centreContent, centreContentParams)


        /**
         * Adding views to mainView
         */
        addView(centreBackgroundView, centreBackgroundViewParams)
        addView(mainContent, mainParams)

        addSpaceItems(leftContent, rightContent)
    }

    private fun setBackgroundColors() {
        rightContent.setBackgroundColor(mainColor)
        centreBackgroundView.setBackgroundColor(mainColor)
        leftContent.setBackgroundColor(mainColor)
    }

    private fun buildCenterCircle(color: Int, size: Int): CenterCircle {
        val centerCircle = CenterCircle(context)
        centerCircle.build(color, size)
        return centerCircle
    }

    private fun postRequestLayout() {
        this.getHandler().post({ this.requestLayout() })
    }

    private fun updateSpaceItems(selectedIndex: Int) {

        /**
         * return if item already selected
         */
        if (currentSelectedItem == selectedIndex && selectedIndex != NOT_DEFINED) {
            onClickBottomViewListener?.onItemReselected(selectedIndex, spaceItems[selectedIndex].itemName)
            return
        }


        if (selectedIndex == CENTRE_BUTTON_INDEX) {
            accentButton.isEnabled = false
            accentButton.backgroundTintList = ColorStateList.valueOf(accentColorPressed)
        }

        if (currentSelectedItem == CENTRE_BUTTON_INDEX) {
            accentButton.isEnabled = true
            accentButton.backgroundTintList = ColorStateList.valueOf(accentColor)
        }

        /**
         * Change active and inactive icon and text color
         */
        for (i in 0 until spaceItemList.size) {
            if (i == selectedIndex) {
                val textAndIconContainer = spaceItemList[selectedIndex] as RelativeLayout
                val spaceItemIcon = textAndIconContainer.findViewById<View>(R.id.space_icon) as ImageView
                val spaceItemText = textAndIconContainer.findViewById<View>(R.id.space_text) as TextView
                spaceItemText.setTextColor(activeSpaceItemColor)
                spaceItemIcon.setColorFilter(activeSpaceItemColor)
            } else if (i == currentSelectedItem) {
                val textAndIconContainer = spaceItemList[i] as RelativeLayout
                val spaceItemIcon = textAndIconContainer.findViewById<View>(R.id.space_icon) as ImageView
                val spaceItemText = textAndIconContainer.findViewById<View>(R.id.space_text) as TextView
                spaceItemText.setTextColor(inActiveSpaceItemColor)
                spaceItemIcon.setColorFilter(inActiveSpaceItemColor)
            }
        }

        /**
         * Set a listener that gets fired when the selected item changes
         *
         * @param listener a listener for monitoring changes in item selection
         */
        if (selectedIndex >= 0)
            onClickBottomViewListener?.onItemClick(selectedIndex, spaceItems[selectedIndex].itemName, spaceItems[selectedIndex].screenName)

        /**
         * Change current selected item index
         */
        currentSelectedItem = selectedIndex
    }

    private fun addSpaceItems(leftContent: LinearLayout, rightContent: LinearLayout) {

        /**
         * Removing all views for not being duplicated
         */
        if (leftContent.childCount > 0 || rightContent.childCount > 0) {
            leftContent.removeAllViews()
            rightContent.removeAllViews()
        }

        /**
         * Clear spaceItemList and badgeList for not being duplicated
         */
        spaceItemList.clear()

        /**
         * Getting LayoutInflater to inflate space item view from XML
         */
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        for (i in spaceItems.indices) {
            val targetWidth: Int

            if (spaceItems.size > MIN_SPACE_ITEM_NUM) {
                targetWidth = contentWidth / 2
            } else {
                targetWidth = contentWidth
            }

            val textAndIconContainerParams = RelativeLayout.LayoutParams(
                    targetWidth, mainContentHeight)
            val textAndIconContainer = inflater.inflate(R.layout.space_item_view, this, false) as RelativeLayout
            textAndIconContainer.layoutParams = textAndIconContainerParams
            textAndIconContainer.gravity = BOTTOM

            val spaceItemIcon = textAndIconContainer.findViewById<View>(R.id.space_icon) as ImageView
            val spaceItemText = textAndIconContainer.findViewById<View>(R.id.space_text) as TextView

            spaceItemIcon.setPadding(0, 0, 0, resources.getDimension(R.dimen.small_padding).toInt())

            spaceItemIcon.setImageResource(spaceItems[i].itemIcon)
            spaceItemText.text = spaceItems[i].itemName
            spaceItemText.setTextSize(TypedValue.COMPLEX_UNIT_PX, labelSize)
            spaceItemText.setTextColor(labelColor)

            /**
             * Adding space items to item list for future
             */
            spaceItemList.add(textAndIconContainer)


            /**
             * Adding sub views to left and right sides
             */
            if (spaceItems.size == MIN_SPACE_ITEM_NUM && leftContent.childCount == 1) {
                rightContent.addView(textAndIconContainer, textAndIconContainerParams)
            } else if (spaceItems.size > MIN_SPACE_ITEM_NUM && leftContent.childCount == 2) {
                rightContent.addView(textAndIconContainer, textAndIconContainerParams)
            } else {
                leftContent.addView(textAndIconContainer, textAndIconContainerParams)
            }

            if (i == currentSelectedItem) {
                spaceItemText.setTextColor(activeSpaceItemColor)
                spaceItemIcon.setColorFilter(activeSpaceItemColor)
            } else {
                spaceItemText.setTextColor(inActiveSpaceItemColor)
                spaceItemIcon.setColorFilter(inActiveSpaceItemColor)
            }


            textAndIconContainer.setOnClickListener {
                updateSpaceItems(i)
            }

        }
    }

    fun setCurrentItem(itemScreenName: String) {
        val item = spaceItems.find { spaceItem ->
            spaceItem.screenName.equals(itemScreenName)
        }
        if (item == null)
            throw ArrayIndexOutOfBoundsException("Item with given name doesen't exist : $itemScreenName")
        else {
            updateSpaceItems(spaceItems.indexOf(item))
        }
    }

    fun addSpaceItem(spaceItem: SpaceItem) {
        spaceItems.add(spaceItem)
    }

    override fun onSaveInstanceState(): Parcelable? {
        val bundle = Bundle()
        bundle.putParcelable("ss", super.onSaveInstanceState())
        bundle.putInt(CURRENT_SELECTED_ITEM_BUNDLE_KEY, currentSelectedItem)
        return bundle
    }

    override fun onRestoreInstanceState(state: Parcelable) {
        val bundle = state as Bundle
        restoreCurrentItem(bundle)
        super.onRestoreInstanceState(bundle.getParcelable("ss"))
    }

    private fun restoreCurrentItem(bundle: Bundle) {
        val restoredBundle = bundle
        if (restoredBundle.containsKey(CURRENT_SELECTED_ITEM_BUNDLE_KEY))
            currentSelectedItem = restoredBundle.getInt(CURRENT_SELECTED_ITEM_BUNDLE_KEY, NOT_DEFINED)

    }


    interface OnClickListener {

        fun onCentreButtonClick()

        fun onItemClick(itemIndex: Int, itemName: String, screenName: String)

        fun onItemReselected(itemIndex: Int, itemName: String)
    }
}
