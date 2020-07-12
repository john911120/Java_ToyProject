from urllib.request import urlopen

imgurl = 'https://cdn.crowdpic.net/detail-thumb/thumb_d_E39CC02702FDE026C36149BBB272E1DA.jpg'
imgname = imgurl.split('/')[-1]
try:
  with urlopen(imgurl) as f:
    with open(imgname,'wb') as h:
      img = f.read()
      h.write(img)
except Exception as e:
  print(e)
