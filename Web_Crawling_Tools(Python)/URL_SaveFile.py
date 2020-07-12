from urllib.request import urlopen

url = 'http://www.naver.com/'
with urlopen(url) as f:
  doc = f.read().decode()
  with open('naver.html','w', -1, "utf-8") as h:
      h.writelines(doc)
