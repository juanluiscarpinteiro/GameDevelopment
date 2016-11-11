package com.gamedevelopment.esdny.gamedevelopment;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    int count=1;
    int lastTouch;
    final ImageAdapter adapter = new ImageAdapter(this);

    public Integer[] aNumbers = {R.drawable.one,R.drawable.two,
            R.drawable.three,R.drawable.four,
            R.drawable.five,R.drawable.six,
            R.drawable.seven,R.drawable.eight,
            R.drawable.nine,R.drawable.ten,
            R.drawable.eleven,R.drawable.twelve,
            R.drawable.thirteen,R.drawable.fourteen,
            R.drawable.fifeteen};


    final String [] alphabet1= new String[] {
            " A "," a"," B "," b "," C ",
            " c "," D "," d "," E "," e ",
            " F "," f "," G "," g "," H ",
            " h "," I "," i "," J "," j "
    };
    public final Integer[] OriginalLoadingScreen = {R.drawable.one,R.drawable.two,
            R.drawable.three,R.drawable.four,
            R.drawable.five,R.drawable.six,
            R.drawable.seven,R.drawable.eight,
            R.drawable.nine,R.drawable.ten,
            R.drawable.eleven,R.drawable.twelve,
            R.drawable.thirteen,R.drawable.fourteen,
            R.drawable.fifeteen};

    public Integer[] emojis = {R.drawable.shy_emoji,R.drawable.shy_emoji,
            R.drawable.money_emoji,R.drawable.money_emoji,
            R.drawable.queen_emoji,R.drawable.queen_emoji,
            R.drawable.glass_emoji,R.drawable.glass_emoji,
            R.drawable.wink_emoji,R.drawable.wink_emoji,
            R.drawable.emoji_sexface,R.drawable.emoji_sexface,
            R.drawable.angel_emoji,R.drawable.angel_emoji,
            R.drawable.fifeteen};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gr = (GridView) findViewById(R.id.gridView1);

        gr.setAdapter (adapter);
        gr.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id)
            {
                Toast.makeText(getBaseContext(),
                        "pic" + (position + 1) + " selected",
                        Toast.LENGTH_SHORT).show();

                checkForMatch(position);
                //adapter.NotifyDataSetChanged();
                count++;

            }
        });
    }

    public class ImageAdapter extends BaseAdapter {


        private Context context;

        public ImageAdapter(Context c)
        {
            context = c;
        }
        @Override
        public int getCount() {
            return aNumbers.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(aNumbers[position]);
            return imageView;
        }
    }



    public void checkForMatch(int position1)
    {
        aNumbers[position1]=emojis[position1];


        if (count % 2==1)
        {
            lastTouch=position1;

        }

        else if (count %2== 0)
        {
            if( alphabet1[lastTouch].equalsIgnoreCase(alphabet1[position1]))
            {
                Toast.makeText(getApplicationContext(),
                        " match maid "+ "this is last touch "+lastTouch + "this is current " + position1 , Toast.LENGTH_SHORT).show();


                //adapter.notifyDataSetChanged();
                count=0;
            }
            else {

                aNumbers[lastTouch]=OriginalLoadingScreen[lastTouch];
                //loadscreen2[position]=" # ";
                aNumbers[position1]=OriginalLoadingScreen[position1];
                //adapter.notifyDataSetChanged();


            }



        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
