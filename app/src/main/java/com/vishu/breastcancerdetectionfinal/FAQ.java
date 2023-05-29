package com.vishu.breastcancerdetectionfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FAQ extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Versions> versionsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
//        getSupportActionBar().setTitle("FAQ");

        recyclerView=findViewById(R.id.recyclerView);

        initData();
        setRecyclerView();
    }



    private void setRecyclerView() {
        VersionsAdapter versionsAdapter =new VersionsAdapter(versionsList);
        recyclerView.setAdapter(versionsAdapter);
        recyclerView.setHasFixedSize(true);
    }
    private void initData() {
        versionsList = new ArrayList<>();

        //so here you can add your required information
        versionsList.add(new Versions("Can breast cancer be ptevented?", "1","A","There is no certain way to prevent breast cancer, since the cause of the disease has not been determined. Early detection followed by prompt\n" +
                "care offers the best chance of treating breast cancer successfully."));
        versionsList.add(new Versions("What are the risk factors for breast cancer?", "2","B","Every woman is at risk for breast cancer. More than 70% of all women diagnosed with breast cancer have no identifiable risk factors. The risk\n" +
                "of developing breast cancer increases as a woman gets older; it also increases if she has a family history of breast cancer, has never had children\n" +
                "or had her first child after age 30, and if she has had prior radiation treatment for Hodgkin’s disease."));
        versionsList.add(new Versions("When should women start having mammograms?", "3","C","Most cancer organizations recommend that women have annual screening mammograms starting at age 40. Mammography is most effective\n" +
                "when it is done regularly — just one mammogram is not enough."));
        versionsList.add(new Versions(" What is the best treatment for early-stage breast cancer?", "4","D","There is a wide range of treatment options, and the best treatment is one that a woman and her doctor decide upon together. For women with\n" +
                "early-stage breast cancer, surgical choices include breast-conserving treatment (lumpectomy) that removes the cancer but not the breast." +
                "Lumpectomy is usually followed by radiation, chemotherapy and/or hormonal therapy."));
        versionsList.add(new Versions("Is there a cure for breast cancer? ", "5","E","No woman treated for breast cancer can be promised a certain cure, but breast cancer is highly treatable. Many women, especially those who\n" +
                "find and treat their breast cancer early, go on to live long and productive lives. There are millions of breast cancer survivors in the world today."));
        versionsList.add(new Versions(" Do diet and exercise affect breast cancer risk?", "6","E","desResearchers are continuing to explore the effect that a healthy, active lifestyle can have on reducing breast cancer risk. Maintaining a diet low in\n" +
                "fat may be beneficial. Following a healthy diet and exercising regularly is good for your overall health, and it may reduce breast cancer risk.\nciption"));
        versionsList.add(new Versions("\n" +
                "Do birth-control pills influence breast cancer risk?", "7","F","Although some studies have shown increased risk for women who used oral contraceptives before 1975, the risk may not be the same for women\n" +
                "using oral contraceptives today. Today’s birth-control pills contain less estrogen and progestins than those manufactured before 1975. \n" +
                "Research is still ongoing, and the decision about whether or not to take these medications should be made by each woman and her doctor,\n" +
                "based upon her individual case."));
        versionsList.add(new Versions(" Besides having mammograms, what else can women do to detect breast cancer?", "8","F","In addition to annual mammograms, all women should have a clinical breast exam (by a doctor or a nurse) every year, starting at age 20. After \n" +
                "age 20, every woman should also check her own breasts regularly."));
        versionsList.add(new Versions("Are all breast lumps cancerous?", "","G","More than 80% of all breast lumps are benign (not cancerous). Breast lumps are very common, especially in younger women, and can come and go \n" +
                "with menstrual cycles. Any unusual lump or a lump that doesn’t go away should be checked by a doctor."));
        versionsList.add(new Versions("How does early detection affect breast cancer survival?", "10","H","When breast cancer is detected and treated at its earliest stage, the five-year survival rate is 97%."));

//sp frinds here i have add some information now
    }
}