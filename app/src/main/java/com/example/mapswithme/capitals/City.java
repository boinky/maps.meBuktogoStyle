/******************************************************************************
 * Copyright (c) 2013, MapsWithMe GmbH All rights reserved.
 * <p/>
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * <p/>
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer. Redistributions in binary form must
 * reproduce the above copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided with the
 * distribution. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY,
 * OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
 * IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGE.
 ******************************************************************************/
package com.example.mapswithme.capitals;

import com.mapswithme.maps.api.MWMPoint;

import java.util.Arrays;
import java.util.Comparator;

public class City {
    private final String id;
    private final String name;
    private final double lat;
    private final double lon;
    private final String countryCode;
    private final int population;
    private final int elevation;
    private final String timeZone;

    public City(String id, String name, double lat, double lon,
                String countryCode, int population, int elevation,
                String timeZone) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.countryCode = countryCode;
        this.population = population;
        this.elevation = elevation;
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        return name;
    }

    public MWMPoint toMWMPoint() {
        return new MWMPoint(lat, lon, name, id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getPopulation() {
        return population;
    }

    public int getElevation() {
        return elevation;
    }

    public String getTimeZone() {
        return timeZone;
    }




    public static City fromMWMPoint(MWMPoint point) {
        City result = null;
        final String id = point.getId();
        if (id != null) {
            for (City city : CAPITALS)
                if (city.getId().equals(id)) {
                    result = city;
                    break;
                }
        }
        return result;
    }

    public static class CityComparator implements Comparator<City> {
        @Override
        public int compare(City lhs, City rhs) {
            return lhs.getName().compareTo(rhs.getName());
        }
    }

    public static City[] CAPITALS = {
            new City("1701668", "Manila", 14.6042, 120.9822, "PH", 10444527, -9999, "Asia/Manila"),
            new City("2116650", "Malaybalay", 8.1575000, 125.1277800, "PH", 10444527, -9999, "Asia/Manila"),
            new City("2116651", "Maramag", 7.7630, 125.0050, "PH", 10444527, -9999, "Asia/Manila"),
            new City("2116652", "Valencia", 7.9000, 125.0833, "PH", 10444527, -9999, "Asia/Manila")
    };

//    static {
//        // Sort'em all at class load!
//        Arrays.sort(City.CAPITALS, new CityComparator());
//    }
}
