from urllib.request import urlopen

url = 'http://www.naver.com'
with urlopen(url) as f:
  doc = f.read().decode()
  print(doc)
