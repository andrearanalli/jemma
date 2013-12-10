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
package org.energy_home.jemma.javagal.layers.object;
import java.util.ArrayList;
import java.util.List;

/**
 * @author "Ing. Marco Nieddu <marco.nieddu@consoft.it> or <marco.niedducv@gmail.com> from Consoft Sistemi S.P.A.<http://www.consoft.it>, financed by EIT ICT Labs activity SecSES - Secure Energy Systems (activity id 13030)"
 *
 */
public class Mgmt_LQI_rsp {
	public short _TranseqNumber;
	public short _Status;
	public short _NeighborTableEntries;
	public short _StartIndex;
	public short _NeighborTableListCount;
	public List<NeighborTableLis_Record> NeighborTableList;

	public Mgmt_LQI_rsp(byte[] data) {
		/* 02 00 01 00 01 */
		_TranseqNumber = data[0];
		_Status = data[1];
		_NeighborTableEntries = data[2];
		_StartIndex = data[3];
		_NeighborTableListCount = data[4];
		if (_NeighborTableListCount > 0) {
			NeighborTableList = new ArrayList<NeighborTableLis_Record>();
			byte[] _newData = org.energy_home.jemma.javagal.layers.business.Utils.copyOfRange(data, 5, data.length);
			for (int i = 0; i < _NeighborTableListCount; i++) {
				byte[] _newData_i = org.energy_home.jemma.javagal.layers.business.Utils.copyOfRange(_newData, (22 * i),
						22 * (i + 1));
				NeighborTableList.add(new NeighborTableLis_Record(_newData_i));
			}
		}
	}
}
