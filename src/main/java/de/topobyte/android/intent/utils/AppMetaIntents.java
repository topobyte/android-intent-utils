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

import java.util.Locale;

import android.content.Context;
import android.content.Intent;

public class AppMetaIntents
{

	public static Intent createMapListIntent(Context context)
	{
		String language = Locale.getDefault().getLanguage();
		return TopobyteIntentFactory.createTopobyteMapsIntent(context,
				language);
	}

}
