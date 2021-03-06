/**
 * This file is part of JEMMA - http://jemma.energy-home.org
 * (C) Copyright 2013 Telecom Italia (http://www.telecomitalia.it)
 *
 * JEMMA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License (LGPL) version 3
 * or later as published by the Free Software Foundation, which accompanies
 * this distribution and is available at http://www.gnu.org/licenses/lgpl.html
 *
 * JEMMA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License (LGPL) for more details.
 *
 */
package org.energy_home.jemma.javagal.layers.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Properties;

import org.energy_home.jemma.javagal.layers.business.implementations.Discovery_Freshness_ForcePing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManageMapPanId {
	String filename;
GalController gal;
private static final Logger logger = LoggerFactory.getLogger(ManageMapPanId.class);

	public ManageMapPanId(GalController _gal) {
		try {
			gal = _gal;
			filename = System.getProperty("user.home") + File.separator + "mapPainId.properties";
			File f = new File(filename);
			if (!f.exists())
				f.createNewFile();
			printFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized Integer getPanid(BigInteger address) {
		FileInputStream stream = null;
		try {
			Properties properties = new Properties();
			stream = new FileInputStream(filename);
			properties.load(stream);
			String _res = properties.getProperty(address.toString());

			if (_res != null)
				return Integer.parseInt(_res, 16);
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {
			if (stream != null)
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

		}
	}

	public synchronized void setPanid(BigInteger address, String panId) {
		FileInputStream stream = null;
		OutputStream out = null;
		try {
			Properties properties = new Properties();
			stream = new FileInputStream(filename);
			properties.load(stream);
			String _oldvalue = properties.getProperty(address.toString());
			if (_oldvalue == null) {
				properties.setProperty(address.toString(), panId);
				out = new FileOutputStream(filename);
				properties.store(out, null);
				out.flush();

			} else if (!_oldvalue.toLowerCase().equals(panId.toLowerCase())) {
				properties.setProperty(address.toString(), panId);
				out = new FileOutputStream(filename);
				properties.store(out, null);
				out.flush();

			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (stream != null)
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

		}
	}

	void printFile() {
		FileInputStream stream = null;
		try {
			Properties properties = new Properties();
			stream = new FileInputStream(filename);
			properties.load(stream);
			Enumeration<?> e = properties.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				if (gal.getPropertiesManager().getDebugEnabled())
					logger.info(key + " -- " + properties.getProperty(key));
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (stream != null)
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

		}

	}

}
