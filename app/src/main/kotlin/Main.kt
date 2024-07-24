package org.bmsk.lifemash.app

import org.bmsk.lifemash.repo.db.encodeXmlEntities
import org.bmsk.lifemash.repo.db.initDatabase
import org.bmsk.lifemash.repo.db.parseXml
import org.bmsk.lifemash.repo.db.saveItemsToDatabase

fun main() {
    // XML 응답 문자열 (예제)
    val xmlResponse = """<rss version="2.0">
    <channel><title>Naver Open API - news ::'주식'</title>
        <link>http://search.naver.com</link>
        <description>Naver Search Result</description>
        <lastBuildDate>Mon, 26 Sep 2016 11:01:35 +0900</lastBuildDate>
        <total>2566589</total>
        <start>1</start>
        <display>10</display>
        <item>
            <title>국내 <b>주식</b>형펀드서 사흘째 자금 순유출</title>
            <originallink>http://app.yonhapnews.co.kr/YNA/Basic/SNS/r.aspx?c=AKR20160926019000008&did=1195m</originallink>
            <link>http://openapi.naver.com/l?AAAC2NSwvCMBCEf832WJK06eOQg+kDLAqCXjyGJqUFk9i0Kv57t0VYdr+ZgZ35ZcJXQFPBIQFZbVBIKOtoDGYQ47o+ITkAa3Gc+SyxU28T4t5bNKyaHJ5glI7d6CBprdcGkvp0rYFldtLIi+mRl0lTFJRQFH4PyM7qz6TISZbmPFoFTfO04JyVnJE8smLADn3sBjlfmvMITFKF63Hbusuha+++xxc/Bc8nKskAAAA=</link>
            <description>국내 <b>주식</b>형 펀드에서 사흘째 자금이 빠져나갔다. 26일 금융투자협회에 따르면 지난 22일 상장지수펀드(ETF)를 제외한 국내 <b>주식</b>형 펀드에서 126억원이 순유출됐다. 472억원이 들어오고 598억원이 펀드... </description>
            <pubDate>Mon, 26 Sep 2016 07:50:00 +0900</pubDate>
        </item>
    </channel>
</rss>"""

    // 엔티티 참조 인코딩
    val encodedXmlResponse = encodeXmlEntities(xmlResponse)

    // 데이터베이스 초기화
    initDatabase()

    // XML 파싱
    val items = parseXml(encodedXmlResponse)

    // 데이터베이스에 저장
    saveItemsToDatabase(items)
}