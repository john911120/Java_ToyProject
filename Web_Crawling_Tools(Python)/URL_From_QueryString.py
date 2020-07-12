url = 'https://news.naver.com/main/read.nhn?mode=LPOD&mid=sec&oid=001&aid=0011738957&isYeonhapFlash=Y&rc=N'

tmp = url.split('?')
queries = tmp[1].split('&')
for query in queries:
  print(query)
