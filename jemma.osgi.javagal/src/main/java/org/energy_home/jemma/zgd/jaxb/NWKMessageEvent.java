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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.9-03/31/2009 04:14 PM(snajper)-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 03:35:00 PM CEST 
//


package org.energy_home.jemma.zgd.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for NWKMessageEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NWKMessageEvent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DstAddrMode" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="DstAddr" type="{http://www.zigbee.org/GWGSchema}NetworkAddress"/>
 *         &lt;element name="SrcAddr" type="{http://www.zigbee.org/GWGSchema}NetworkAddress"/>
 *         &lt;element name="Nsdu" type="{http://www.w3.org/2001/XMLSchema}hexBinary"/>
 *         &lt;element name="LinkQuality" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="RxTime" type="{http://www.zigbee.org/GWGSchema}unsigned32Bit" minOccurs="0"/>
 *         &lt;element name="SecurityUse" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NWKMessageEvent", propOrder = {
    "dstAddrMode",
    "dstAddr",
    "srcAddr",
    "nsdu",
    "linkQuality",
    "rxTime",
    "securityUse"
})
public class NWKMessageEvent {

    @XmlElement(name = "DstAddrMode")
    @XmlSchemaType(name = "unsignedByte")
    protected short dstAddrMode;
    @XmlElement(name = "DstAddr")
    protected int dstAddr;
    @XmlElement(name = "SrcAddr")
    protected int srcAddr;
    @XmlElement(name = "Nsdu", required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] nsdu;
    @XmlElement(name = "LinkQuality")
    @XmlSchemaType(name = "unsignedByte")
    protected Short linkQuality;
    @XmlElement(name = "RxTime")
    protected Long rxTime;
    @XmlElement(name = "SecurityUse")
    protected boolean securityUse;

    /**
     * Gets the value of the dstAddrMode property.
     * 
     */
    public short getDstAddrMode() {
        return dstAddrMode;
    }

    /**
     * Sets the value of the dstAddrMode property.
     * 
     */
    public void setDstAddrMode(short value) {
        this.dstAddrMode = value;
    }

    /**
     * Gets the value of the dstAddr property.
     * 
     */
    public int getDstAddr() {
        return dstAddr;
    }

    /**
     * Sets the value of the dstAddr property.
     * 
     */
    public void setDstAddr(int value) {
        this.dstAddr = value;
    }

    /**
     * Gets the value of the srcAddr property.
     * 
     */
    public int getSrcAddr() {
        return srcAddr;
    }

    /**
     * Sets the value of the srcAddr property.
     * 
     */
    public void setSrcAddr(int value) {
        this.srcAddr = value;
    }

    /**
     * Gets the value of the nsdu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getNsdu() {
        return nsdu;
    }

    /**
     * Sets the value of the nsdu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNsdu(byte[] value) {
        this.nsdu = ((byte[]) value);
    }

    /**
     * Gets the value of the linkQuality property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getLinkQuality() {
        return linkQuality;
    }

    /**
     * Sets the value of the linkQuality property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setLinkQuality(Short value) {
        this.linkQuality = value;
    }

    /**
     * Gets the value of the rxTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRxTime() {
        return rxTime;
    }

    /**
     * Sets the value of the rxTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRxTime(Long value) {
        this.rxTime = value;
    }

    /**
     * Gets the value of the securityUse property.
     * 
     */
    public boolean isSecurityUse() {
        return securityUse;
    }

    /**
     * Sets the value of the securityUse property.
     * 
     */
    public void setSecurityUse(boolean value) {
        this.securityUse = value;
    }

}
