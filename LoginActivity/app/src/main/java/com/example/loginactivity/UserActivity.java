package com.example.loginactivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.card.MaterialCardView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {
    private TextView tvFirstLast;
    private TextView tvEmailAddress;
    private TextView tvUserDescription;
    private RecyclerView rvEventHistory;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private User user;

    private void popPage() {
        user = new User("1234", "Mark", "Benedict", "markBenedict@gmail.com", "blabla12345", "Student", "UTS");
        user.setDescription("Enthusiastic school leaver with five GCSEs looking for an apprenticeship in the engineering field. Possessing good written and verbal communication and an interest in engineering which has spanned my lifetime with a particular passion for electrics. For my GCSE Design & Technology project, I built a working calculator and was awarded an A+. Looking for a start in the exciting world of electrical engineering where I can learn a trade and realise a lifetime ambition.");
        for (Event event: EventStorage.getEvents()) {
            user.setEvent(event);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        tvFirstLast = findViewById(R.id.tvUserName);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/BadBlocks");
        tvFirstLast.setTypeface(myCustomFont);
        tvEmailAddress = findViewById(R.id.tvEmailAddress);
        tvUserDescription = findViewById(R.id.tvUserDescription);
        popPage();
        rvEventHistory = findViewById(R.id.rvEventHistory);
        rvEventHistory.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvEventHistory.setLayoutManager(layoutManager);
        mAdapter = new AdaptorEvent(user.getEventHistory());
        rvEventHistory.setAdapter(mAdapter);
        rvEventHistory.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        setCardViewBackgroundToRecyclerView(rvEventHistory);

        tvFirstLast.setText(user.getFirstName() + " " + user.getLastName() + "'s Profile");
        tvEmailAddress.setText(user.getEmailAddress());
        tvUserDescription.setText(user.getDescription());

    }

    private void setCardViewBackgroundToRecyclerView(RecyclerView recyclerView) {
        MaterialCardView cardView = new MaterialCardView(this);
        cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite));
        cardView.setUseCompatPadding(true);
        cardView.setPreventCornerOverlap(false);
        cardView.setRadius(65);
        int cardShadow = (int) cardView.getCardElevation();
        recyclerView.setPadding(cardView.getContentPaddingLeft() + cardShadow,
                cardView.getContentPaddingTop() + cardShadow + 3,
                cardView.getContentPaddingRight() + cardShadow,
                cardView.getContentPaddingBottom() + cardShadow + 3);
        ViewCompat.setElevation(recyclerView, 8);
        recyclerView.setBackground(cardView.getBackground());
    }
}
