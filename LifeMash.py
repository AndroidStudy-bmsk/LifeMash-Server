import requests
from bs4 import BeautifulSoup
from transformers import pipeline
import schedule
import time


def fetch_news(url):
    response = requests.get(url)
    soup = BeautifulSoup(response.content, 'html.parser')

    headlines = soup.find_all('h2', class_='news_headline')
    news_list = [{'title': h.text, 'link': h.a['href']} for h in headlines if h.a]

    return news_list


summarizer = pipeline("summarization")


def summarize_news(articles):
    summaries = []
    for article in articles:
        summary = summarizer(article['title'], max_length=50, min_length=25, do_sample=False)
        summaries.append({'title': article['title'], 'summary': summary[0]['summary_text']})
    return summaries


def job():
    url = "https://example-news-site.com"
    news_articles = fetch_news(url)
    news_summaries = summarize_news(news_articles)
    for summary in news_summaries:
        print(summary)


# 매일 정해진 시간에 작업 실행, 예: 매일 오전 9시
schedule.every().day.at("09:00").do(job)

while True:
    schedule.run_pending()
    time.sleep(60)  # 1분마다 체크
