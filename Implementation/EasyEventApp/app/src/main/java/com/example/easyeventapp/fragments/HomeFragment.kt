package com.example.easyeventapp.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easyeventapp.LoginActivity
import com.example.easyeventapp.data.MostViewed
import com.example.easyeventapp.R
import com.example.easyeventapp.adpater.MostViewedAdapter
import com.example.easyeventapp.adpater.VenueAdapter
import com.example.easyeventapp.featured_venue_data
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_home.*



class HomeFragment : Fragment() {

    private val HomeFragment: Context? = null
    private lateinit var  venueRecyclerView: RecyclerView
    private lateinit var  venueArraylist : ArrayList<featured_venue_data>
    lateinit var imageId : Array<Int>
    lateinit var title : Array<String>
    lateinit var description: Array<String>

    lateinit var mvImageId : Array<Int>
    lateinit var mvTitle : Array<String>
    lateinit var mvDescription: Array<String>
    private lateinit var  mvRecyclerView: RecyclerView
    private lateinit var  mvArraylist : ArrayList<MostViewed>

    private lateinit var signOut : ImageView




    override fun onCreateView(



        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_home, container, false)

        signOut = view.findViewById(R.id.signOut)

        signOut.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(activity, LoginActivity::class.java))
            requireActivity().finish()
        }


        return view
    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        featuredAdapterView()
        MostviewedAdapterView()


    }


    private fun featuredAdapterView(){
        imageId = arrayOf(
            R.drawable.aloft,
            R.drawable.everest,
            R.drawable.soltee,
            R.drawable.hyatt,
            R.drawable.yak
        )
        title = arrayOf(
            "Aloft",
            "The Everest Hotel",
            "Soltee Crownee Plaza",
            "Hyaat Regency",
            "Hotel Yak and Yeti"

        )

        description = arrayOf(
            "Experience the city from Aloft Kathmandu Thamel, the Marriott International urban-inspired and stylishly designed brand. Situated in the heart of the bustling capital and Thamel, a tourism heaven where you can unwind, explore and experience the true essence of Nepal. Just minutes away from UNSECO Heritage Sites, it truly is an epicenter of entertainment and glamour, blending local and global experiences. Our boutique hotel is only a 20-minute drive from Tribhuvan International Airport. Unwind in modern hotel rooms with fast and free Wi-Fi and ultra-comfortable bedding. Break a sweat in our well-equipped fitness center, followed by a meal in our hotel restaurant. Or simply pick up a grab-and-go snack from Re:fuel. Host your next gathering in our flexible spaces, equipped with the latest AV technology. Make Aloft Kathmandu Thamel your vibrant home away from home in Kathmandu, Nepal",
            "The Everest Hotel is located just 3 Kms from Kathmandu International Airport and International Convention Centre and conveniently established at a place surrounded by Tourist hotspots, shopping Centre, Pashupatinath and Changu Narayan Temple. View of the mountains in the heart of city & Nepali Culture, these vistas are best admired from the hotel’s 160 rooms and suites, aesthetically and tastefully appointed, the rooms are well lit and offer all modern amenities such as spacious wardrobe, an LCD television, mini bar, complimentary high speed internet for up to two devices per room. ",
            "An exceptional blend of royal and traditional elegance, The Soaltee Kathmandu - Soaltee Nepal’s premier 5 Star Deluxe hotel is set in lush green 12 acres of landscaped area with a magnificent view of the Himalayas. It’s located in peaceful Tahachal just 8km from the Tribhuvan International Airport and 4km from the city center its finest shopping destinations, cultural attractions, and entertainment options in Kathmandu. While staying at this 5-star hotel in Kathmandu, you enjoy a range of prime amenities. Gaze up at the mountains while you float in the pool or unwind with one of our rejuvenating therapies at the Tranquility Spa, the largest in the city.",
            "Hyatt Regency Kathmandu is a five-star luxury hotel and resort in Kathmandu,  set on 37 acres of landscaped grounds and created in the traditional Newari style of Nepalese architecture. This beautiful hotel and resort is located on the road to the Boudhanath Stupa: the most holy of all Tibetan Buddhist shrines outside of Tibet and a UNESCO World Heritage Site located within a five-minute walk from the hotel. The hotel is just four kilometres (2.4 miles) from the Tribhuvan International Airport and six kilometres (3.7 miles) from the city center of Kathmandu.",
            "Yak and Yeti is a heritage hotel located in Durbar Marg, the thriving city center of Kathmandu Valley, in a prime location that is minutes walking distance from the former Royal Palace. Durbar marg is a commercial area with high-end shops and a variety of food options. Our 5 star deluxe luxury property is 6 KM away from the Tribhuvan International Airport, about 1 KM from the famous tourist hub of Nepal- Thamel."
        )



        venueRecyclerView = featuredVenueRecyclerView
        venueRecyclerView.layoutManager = LinearLayoutManager(activity)
        venueRecyclerView.setHasFixedSize(true)
        venueRecyclerView.layoutManager = LinearLayoutManager(HomeFragment, RecyclerView.HORIZONTAL, false)
        venueArraylist = arrayListOf<featured_venue_data>()
        getFeaturedVenueData()


    }


    private fun getFeaturedVenueData() {


        for(i in imageId.indices){
            val featuredVenueData = featured_venue_data(imageId[i], title[i], description[i])
            venueArraylist.add(featuredVenueData)
        }

        venueRecyclerView.adapter = VenueAdapter(venueArraylist)
    }

    private fun MostviewedAdapterView(){

        Log.d("Main", "I'm here 2")

        mvImageId = arrayOf(
            R.drawable.birthdayevent,
            R.drawable.weddingevent,
            R.drawable.holi,
            R.drawable.workshopevent,
            R.drawable.newyearevent
        )
        mvTitle = arrayOf(
            "Birthday Party Event",
            "Wedding Party",
            "Festival 0f Colors, 'Holi' ",
            "A WorkPlace Event",
            "New Year Eve Party"

        )

        mvDescription = arrayOf(

            "A Birthday Party orgamized with the help of Easy Event",
            "Couple tying their knots together forever with the help fabulous event organized by the help of Easy Event",
            "Let this Holi be more fun and eventful with Easy Event",
            "Workshop events can be Easy with Easy Events",
            "Wishing You all A very Happy New Year from Easy Event Family"


             )



        mvRecyclerView = mostViewedRecycleView
        mostViewedRecycleView.layoutManager = LinearLayoutManager(HomeFragment)
        mostViewedRecycleView.setHasFixedSize(true)
        mostViewedRecycleView.layoutManager = LinearLayoutManager(HomeFragment, RecyclerView.HORIZONTAL, false)
        mvArraylist = arrayListOf<MostViewed>()
        getMostViewedData()


    }

    private fun getMostViewedData(){

        for(i in mvImageId.indices){
            val mostViewedData = MostViewed(mvImageId[i], mvTitle[i], mvDescription[i])
            mvArraylist.add(mostViewedData)
        }

        mvRecyclerView.adapter = MostViewedAdapter(mvArraylist)

    }


    }
