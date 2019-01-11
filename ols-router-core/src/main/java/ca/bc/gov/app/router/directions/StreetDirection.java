/**
 * Copyright 2008-2019, Province of British Columbia
 *  All rights reserved.
 */
package ca.bc.gov.app.router.directions;

import ca.bc.gov.app.router.api.ApiResponse;
import ca.bc.gov.app.router.util.TimeHelper;

import com.vividsolutions.jts.geom.Point;

public class StreetDirection extends AbstractTravelDirection {
	protected final StreetDirectionType type;
	
	public StreetDirection(Point point, StreetDirectionType type, String streetName) {
		super(point, streetName);
		this.type = type;
	}

	public StreetDirection(Point point, StreetDirectionType type, String streetName, double distance, double time) {
		super(point, streetName, distance, time);
		this.type = type;
	}

	@Override
	public String getType() {
		return type.name();
	}

	public String format(ApiResponse response) {
		String distStr = response.getDistanceUnit().formatForDirections(distance);
		String str = type.toString() + " onto " + streetName + (distStr.isEmpty() ? "" : (" for " + distStr))
				+ (time == 0 ? "" : (" (" + TimeHelper.formatTime(time) + ")"));
		return str;
	}

}
