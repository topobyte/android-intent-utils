// Copyright 2014 Sebastian Kuerten
//
// This file is part of android-intent-utils.
//
// android-intent-utils is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// android-intent-utils is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with android-intent-utils. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.android.intent.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class IntentFactory {

	public static Intent createUrlIntent(String url) {
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		return intent;
	}

	public static Intent createWikipediaIntent(String languageCode,
			String pageName) {
		String url = "http://" + languageCode + ".wikipedia.org/wiki/"
				+ pageName;
		return createUrlIntent(url);
	}

	public static Intent createTopobyteAppsIntent() {
		String link = "market://search?q=pub:Topobyte.de";
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(link));
		return intent;
	}

	private static String mapsUrl = "http://spm.topobyte.de/apps";

	public static Intent createTopobyteMapsIntent(Context context) {
		String packageName = context.getApplicationContext().getPackageName();
		String url = mapsUrl + "?id=" + packageName;
		return IntentFactory.createUrlIntent(url);
	}

	public static Intent createTopobyteMapsIntent(Context context, String lang) {
		String packageName = context.getApplicationContext().getPackageName();
		String url = mapsUrl + "?lang=" + lang + "&id=" + packageName;
		return IntentFactory.createUrlIntent(url);
	}

	public static Intent createAppDetailsIntent(String packageName) {
		String link = "market://details?id=" + packageName;
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(link));
		return intent;
	}

	public static Intent createStadtplanNGAppDetailIntent(String identifier) {
		String packageName = "de.topobyte.apps.offline.stadtplan." + identifier;
		return createAppDetailsIntent(packageName);
	}

	private static String weatherUrl = "http://weather.topobyte.de/weather/";

	public static Intent createTopobyteWeatherIntent(String iso3, String name,
			String lang, boolean preferFahrenheit) {
		String url = weatherUrl + iso3 + "/" + name + "?lang=" + lang;
		if (preferFahrenheit) {
			url += "&unit=f";
		}
		return IntentFactory.createUrlIntent(url);
	}

	public static Intent createThanksAppDetailIntent(ThankOption amount) {
		String packageName;
		switch (amount) {
		default:
		case THANK_1:
			packageName = "de.topobyte.apps.thanks.amount1";
			break;
		case THANK_2:
			packageName = "de.topobyte.apps.thanks.amount2";
			break;
		case THANK_5:
			packageName = "de.topobyte.apps.thanks.amount5";
			break;
		case THANK_10:
			packageName = "de.topobyte.apps.thanks.amount10";
			break;
		}
		return createAppDetailsIntent(packageName);
	}

	public static Intent createRateAppIntent(Context context) {
		String packageName = context.getApplicationContext().getPackageName();
		return createAppDetailsIntent(packageName);
	}
}
