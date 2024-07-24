package org.bmsk.lifemash.repo.db

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue

fun encodeXmlEntities(xml: String): String {
    return xml.replace("&", "&amp;")
}

fun parseXml(xmlString: String): List<Item> {
    val xmlMapper = XmlMapper().apply { registerModule(KotlinModule()) }
    val rss: Rss = xmlMapper.readValue(xmlString)
    return rss.channel.item
}