//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.0.1.
//


package com.opentaxi.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import com.opentaxi.android.R.id;
import com.opentaxi.android.R.layout;
import com.stil.generated.mysql.tables.pojos.Cars;
import org.androidannotations.api.BackgroundExecutor;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class CarDetailsActivity_
    extends CarDetailsActivity
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();
    public final static String CAR_NUMBER_EXTRA = "carNumber";
    private Handler handler_ = new Handler(Looper.getMainLooper());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.car_details);
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        injectExtras_();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static CarDetailsActivity_.IntentBuilder_ intent(Context context) {
        return new CarDetailsActivity_.IntentBuilder_(context);
    }

    public static CarDetailsActivity_.IntentBuilder_ intent(Fragment supportFragment) {
        return new CarDetailsActivity_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        carNumberView = ((TextView) hasViews.findViewById(id.carNumberView));
        driver = ((TextView) hasViews.findViewById(id.driver));
        requestButton = ((Button) hasViews.findViewById(id.requestButton));
        rating = ((RatingBar) hasViews.findViewById(id.rating));
        {
            View view = hasViews.findViewById(id.okButton);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        CarDetailsActivity_.this.okButton();
                    }

                }
                );
            }
        }
        {
            View view = hasViews.findViewById(id.requestButton);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        CarDetailsActivity_.this.requestButton();
                    }

                }
                );
            }
        }
        afterRequestsActivity();
    }

    private void injectExtras_() {
        Bundle extras_ = getIntent().getExtras();
        if (extras_!= null) {
            if (extras_.containsKey(CAR_NUMBER_EXTRA)) {
                carNumber = extras_.getString(CAR_NUMBER_EXTRA);
            }
        }
    }

    @Override
    public void setIntent(Intent newIntent) {
        super.setIntent(newIntent);
        injectExtras_();
    }

    @Override
    public void showDetails(final Cars cars) {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                CarDetailsActivity_.super.showDetails(cars);
            }

        }
        );
    }

    @Override
    public void setDetails() {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0, "") {


            @Override
            public void execute() {
                try {
                    CarDetailsActivity_.super.setDetails();
                } catch (Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }

        }
        );
    }

    public static class IntentBuilder_ {

        private Context context_;
        private final Intent intent_;
        private Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            context_ = context;
            intent_ = new Intent(context, CarDetailsActivity_.class);
        }

        public IntentBuilder_(Fragment fragment) {
            fragmentSupport_ = fragment;
            context_ = fragment.getActivity();
            intent_ = new Intent(context_, CarDetailsActivity_.class);
        }

        public Intent get() {
            return intent_;
        }

        public CarDetailsActivity_.IntentBuilder_ flags(int flags) {
            intent_.setFlags(flags);
            return this;
        }

        public void start() {
            context_.startActivity(intent_);
        }

        public void startForResult(int requestCode) {
            if (fragmentSupport_!= null) {
                fragmentSupport_.startActivityForResult(intent_, requestCode);
            } else {
                if (context_ instanceof Activity) {
                    ((Activity) context_).startActivityForResult(intent_, requestCode);
                } else {
                    context_.startActivity(intent_);
                }
            }
        }

        public CarDetailsActivity_.IntentBuilder_ carNumber(String carNumber) {
            intent_.putExtra(CAR_NUMBER_EXTRA, carNumber);
            return this;
        }

    }

}
