package com.example.edplus.receipe_well_done.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.edplus.receipe_well_done.R;
import com.example.edplus.receipe_well_done.ReceipeApplication;
import com.example.edplus.receipe_well_done.jsonParserReceipe.ReceipeDetailsParser;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class NetworkActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        textView = (TextView)findViewById(R.id.textView);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://ec2-34-213-111-5.us-west-2.compute.amazonaws.com:3030/receipe_5";


                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Gson gson = new Gson();
                        //ReceipeDetailsParser receipeDetailsParser = gson.fromJson(response,ReceipeDetailsParser.class);
                        //Log.e("Parsing", receipeDetailsParser.toString());
                        Log.e("output", response);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", error.toString());
                    }
                }) {
                    @Override
                    public Map<String, String> getParams() {
                        Map<String, String> mParams = new HashMap<String, String>();
                        String query = "PREFIX semantic: <http://www.semanticweb.org/ser594/ontologies/2017/9/untitled-ontology-7#>\n" +
                                "SELECT Distinct ?hasDishName ?hasCookingTime ?hasflavourProfile ?isRatedAs ?hasIngredients ?belongsToCourse \n" +
                                "?belongsTo ?hasNutrient ?isServedIn ?hasInstructions ?url\n" +
                                "WHERE {\n" +
                                " <http://127.0.0.1:3333/Revolutionary-Mac-_-Cheese-1048867>  semantic:hasDishName ?hasDishName.\n" +
                                " <http://127.0.0.1:3333/Revolutionary-Mac-_-Cheese-1048867>  semantic:hasCookingTime ?hasCookingTime.\n" +
                                " <http://127.0.0.1:3333/Revolutionary-Mac-_-Cheese-1048867>  semantic:hasflavourProfile ?hasflavourProfile.\n" +
                                " <http://127.0.0.1:3333/Revolutionary-Mac-_-Cheese-1048867>  semantic:isRatedAs ?isRatedAs .\n" +
                                " <http://127.0.0.1:3333/Revolutionary-Mac-_-Cheese-1048867>  semantic:belongsToCourse ?belongsToCourse . \n" +
                                " <http://127.0.0.1:3333/Revolutionary-Mac-_-Cheese-1048867>  semantic:belongsTo ?belongsTo.\n" +
                                " <http://127.0.0.1:3333/Revolutionary-Mac-_-Cheese-1048867>  semantic:isServedIn ?isServedIn .\n" +
                                " <http://127.0.0.1:3333/Revolutionary-Mac-_-Cheese-1048867>  <http://127.0.0.1:3333/hasInstructions> ?hasInstructions.\n" +
                                " <http://127.0.0.1:3333/Revolutionary-Mac-_-Cheese-1048867> <http://127.0.0.1:3333/image>  ?url .\n" +
                                "}";

                       // String receipeURL = "";

                        //query = query.replace("<http://127.0.0.1:3333/Revolutionary-Mac-_-Cheese-1048867>");


                        String restuarantInfo = "" +
                                "PREFIX semantic: <http://www.semanticweb.org/ser594/ontologies/2017/9/untitled-ontology-7#>\n" +
                                "SELECT ?hasRestaurantName ?isLocatedAtWeb ?isLocatedAtPhysical ?isLocatedInCity ?isLocatedAt ?servesCuisine ?costRated ?hasRating\n" +
                                "WHERE {\n" +
                                " <http://127.0.0.1:3333/1.7028613E7>  semantic:hasRestaurantName ?hasRestaurantName.\n" +
                                " <http://127.0.0.1:3333/1.7028613E7>  semantic:isLocatedAtWeb ?isLocatedAtWeb.\n" +
                                " <http://127.0.0.1:3333/1.7028613E7>  semantic:isLocatedAtPhysical ?isLocatedAtPhysical.\n" +
                                " <http://127.0.0.1:3333/1.7028613E7>  semantic:isLocatedInCity ?isLocatedInCity.\n" +
                                " <http://127.0.0.1:3333/1.7028613E7>  semantic:isLocatedAt ?isLocatedAt.\n" +
                                " <http://127.0.0.1:3333/1.7028613E7>  semantic:servesCuisine ?servesCuisine.\n" +
                                " <http://127.0.0.1:3333/1.7028613E7>  semantic:costRated ?costRated.\n" +
                                " <http://127.0.0.1:3333/1.7028613E7>  semantic:hasRating ?hasRating.\n" +
                                "  \n" +
                                "}";


                        String ingredientQuery = "\n" +
                                "PREFIX semantic: <http://www.semanticweb.org/ser594/ontologies/2017/9/untitled-ontology-7#>\n" +
                                "\n" +
                                "SELECT ?hasIngredients\n" +
                                "WHERE {\n" +
                                " <http://127.0.0.1:3333/Revolutionary-Mac-_-Cheese-1048867>  semantic:hasIngredients ?hasIngredients.\n" +
                                "}";

                        String query1 = "PREFIX semantic: <http://www.semanticweb.org/ser594/ontologies/2017/9/untitled-ontology-7#>  SELECT DISTINCT ?Recipe WHERE { ?DishName semantic:hasDishName ?Recipe}";


                        String cocktailDetailQuery =
                                "  PREFIX semantic: <http://www.semanticweb.org/ser594/ontologies/2017/9/untitled-ontology-7#>\n" +
                                        "\n" +
                                        "  SELECT Distinct ?hasDrinkName ?belongsToDrinkCategory ?drinkHasImage ?isPreparedAs\n" +
                                        "  WHERE {\n" +
                                        "   <http://127.0.0.1:3333/12564>  semantic:hasDrinkName ?hasDrinkName.\n" +
                                        "   <http://127.0.0.1:3333/12564>  semantic:belongsToDrinkCategory ?belongsToDrinkCategory.\n" +
                                        "   <http://127.0.0.1:3333/12564>  <http://127.0.0.1:3333/drinkHasImage> ?drinkHasImage.\n" +
                                        "   <http://127.0.0.1:3333/12564>  semantic:isPreparedAs ?isPreparedAs .\n" +
                                        "  }";


                        String cocktailIngredient = "" +
                                "  PREFIX semantic: <http://www.semanticweb.org/ser594/ontologies/2017/9/untitled-ontology-7#>\n" +
                                "\n" +
                                "  SELECT Distinct ?isPreparedWith\n" +
                                "  WHERE {\n" +
                                "   <http://127.0.0.1:3333/12564>  semantic:isPreparedWith ?isPreparedWith .\n" +
                                "  \t\n" +
                                "  }";

                        mParams.put("query", cocktailIngredient);
                        mParams.put("output","json");
                        return mParams;
                    }

                    /**
                     * Passing some request headers
                     * */
//                    @Override
//                    public Map<String, String> getHeaders() throws AuthFailureError {
//                        HashMap<String, String> headers = new HashMap<String, String>();
//                        headers.put("content-type", "application/sparql-results+json");
//                        return headers;
//                    }
                } ;



                ReceipeApplication.getInstance().addToRequestQueue(stringRequest);


            }



        });
    }
}