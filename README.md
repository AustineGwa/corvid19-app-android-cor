# corvid19-app-android-cor
An app developed to give quick data access for corvid 19


<b>Maps Activity will not run untill you put your own maps key </b>

 open the string file (google-maps-sdk.xml file)
 
     //Once you have your key (it starts with "AIza"), replace the "google_maps_key"
     string in this file.
    -->
    <string name="google_maps_key" templateMergeStrategy="preserve" translatable="false">put your api key here </string>



<h3>Release apk </h3>

the app uses a debug mode sha1 certificate -google auth only works with debug mode apk

to run a release apk , 

1. point the app to your own firebase project <br/>
2. Generate a sign in Id token from your gcp console and pass to the GoogleSignInOptions builder.

        // Configure Google Sign In
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)

                //for debug mode apk replace with your app id when building release apks
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .requestProfile()
                .build();
                
  3. Generate a release SHA1 and add to your firebase project , download the json file and replace with one in your current        app directory


---add something if you see this shallow
