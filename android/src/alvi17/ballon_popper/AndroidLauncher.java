package alvi17.ballon_popper;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class AndroidLauncher extends AndroidApplication {

	InterstitialAd interstitialAd;
	Boolean adLoaded=false;

	boolean first_time=true;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useImmersiveMode = true;
		initialize(new Balloons(), config);

	}

	public void initAds()
	{
		interstitialAd=new  InterstitialAd(this);
		interstitialAd.setAdUnitId("ca-app-pub-6508526601344465/1333644433");
		AdRequest aRequest = new AdRequest.Builder().addTestDevice("0754C239B1E2E19421FDE46BCEFB8855").build();

		// Begin loading your interstitial.
		interstitialAd.loadAd(aRequest);

		interstitialAd.setAdListener(
				new AdListener() {
					@Override
					public void onAdLoaded() {
						super.onAdLoaded();
						adLoaded=true;
					}
				}
		);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		if(adLoaded)
		{
			interstitialAd.show();
			adLoaded=false;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if(!adLoaded)
		{
			initAds();
		}
	}
}
