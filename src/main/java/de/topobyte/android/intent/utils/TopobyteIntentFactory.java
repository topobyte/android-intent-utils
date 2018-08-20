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

public class TopobyteIntentFactory
{

	public static Intent createTopobyteAppsIntent()
	{
		return IntentFactory.createGooglePlayPublisherIntent("Topobyte.de");
	}

	private static String mapsUrl = "http://spm.topobyte.de/apps";
	private static String faqUrl = "http://spm.topobyte.de/faq";

	public static Intent createTopobyteMapsIntent(Context context)
	{
		String packageName = context.getApplicationContext().getPackageName();
		String url = mapsUrl + "?id=" + packageName;
		return IntentFactory.createUrlIntent(url);
	}

	public static Intent createTopobyteMapsIntent(Context context, String lang)
	{
		String packageName = context.getApplicationContext().getPackageName();
		String url = mapsUrl + "?lang=" + lang + "&id=" + packageName;
		return IntentFactory.createUrlIntent(url);
	}

	public static Intent createTopobyteFAQIntent(Context context)
	{
		String packageName = context.getApplicationContext().getPackageName();
		String url = faqUrl + "?id=" + packageName;
		return IntentFactory.createUrlIntent(url);
	}

	public static Intent createTopobyteFAQIntent(Context context, String lang)
	{
		String packageName = context.getApplicationContext().getPackageName();
		String url = faqUrl + "?lang=" + lang + "&id=" + packageName;
		return IntentFactory.createUrlIntent(url);
	}

	public static Intent createStadtplanNGAppDetailIntent(String identifier)
	{
		String packageName = "de.topobyte.apps.offline.stadtplan." + identifier;
		return IntentFactory.createGooglePlayAppDetailsIntent(packageName);
	}

	private static String weatherUrl = "http://weather.topobyte.de/weather/";

	public static Intent createTopobyteWeatherIntent(String iso3, String name,
			String lang, boolean preferFahrenheit)
	{
		String url = weatherUrl + iso3 + "/" + name + "?lang=" + lang;
		if (preferFahrenheit) {
			url += "&unit=f";
		}
		return IntentFactory.createUrlIntent(url);
	}

	public static Intent createThanksAppDetailIntent(ThankOption amount)
	{
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
		return IntentFactory.createGooglePlayAppDetailsIntent(packageName);
	}

	public static Intent createAppManagerIntent(Context context)
	{
		String packageName = "de.topobyte.topobyteapps";
		return IntentFactory.createGooglePlayAppDetailsIntent(packageName);
	}

	public static Intent createDiceIntent(Context context)
	{
		String packageName = "de.topobyte.games.dice";
		return IntentFactory.createGooglePlayAppDetailsIntent(packageName);
	}

	public static Intent createAtlasIntent(Context context)
	{
		String packageName = "de.topobyte.apps.bms.atlas";
		return IntentFactory.createGooglePlayAppDetailsIntent(packageName);
	}

}
