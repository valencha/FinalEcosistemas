package icesi.dmi.com.finalecosistemas;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ListView;

import java.text.AttributedCharacterIterator;

public class ExpandableHeightListView extends ListView {

    boolean expanded = false;

    public ExpandableHeightListView(Context context) {
        super(context);
    }

    public ExpandableHeightListView(Context context, AttributeSet attrs){
        super(context,attrs);
    }


    public ExpandableHeightListView(Context context, AttributeSet attrs,int defStyle){
        super(context,attrs,defStyle);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {


            int heightMeasureSpec_custom = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec,heightMeasureSpec_custom);
            ViewGroup.LayoutParams params= getLayoutParams();
            params.height = getMeasuredHeight();

    }


}
