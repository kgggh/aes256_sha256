# 암호화 복호화 

<h1>jasypt의 PBEWithMD5AndDES 알고리즘을 사용 하여 key값을 입력 받아 암호화 및 복호화</h1>
<h3>saltGenerator를 지정하지 않으면 RandomSaltGenerator를 default로 사용한다.</h3>
<h3>RandomSalt를 사용하는 경우는 암호화된 결과 값이 매번 바뀐다.</h3>
<h3>StringFixedSaltGenerator를 사용해 고정된 salt값을 지정하면 암호화된 결과 값이 고정돼서 반환된다.</h3>
<br><br><br><br><br>

<ul>
  <li><p>key값을 입력한다</li>
  <br><br><br>
  <img width ="100%" src="https://user-images.githubusercontent.com/68227318/101934045-61a8bb00-3c20-11eb-8cfc-7847c447f342.jpg">
  <br><br><br>

  <li>key값을 입력 후 암호화 버튼을 누른 후 암호화 된 결과</li>
  <br><br><br>
  <img width ="100%" src="https://user-images.githubusercontent.com/68227318/101934054-64a3ab80-3c20-11eb-93b1-4da23ca62de4.jpg">
  <br><br><br>

  <li>암호화된 key값을 복호화 버튼을 누른후 복호화한 결과</li>
  <br><br><br>
  <img width ="100%" src="https://user-images.githubusercontent.com/68227318/101934058-67060580-3c20-11eb-9ceb-3bc766a5db41.jpg">
  <br><br><br>
</ul>


# AES-256,SHA-256암호화 로그인처리

<ul>
  <li>아이디,패스워드 틀렸을 시</li>
  <br><br><br>
  <img width ="100%" src="https://user-images.githubusercontent.com/68227318/102123725-9cae2700-3e8a-11eb-94df-6ee10363dfb3.jpg">
  <img width ="100%" src="https://user-images.githubusercontent.com/68227318/102122003-39bb9080-3e88-11eb-9fdf-005f2fb3b41d.jpg">

  <li>입력받은 아이디 패스워드를 AES256 암호화 -> 로그인 성공 시 암호화된 결과값을 화면에 표시 </li>
  <br><br><br>
  <img width ="100%" src="https://user-images.githubusercontent.com/68227318/102122539-f281cf80-3e88-11eb-9a97-67ea5d6302e5.jpg">
  <img width ="100%" src="https://user-images.githubusercontent.com/68227318/102122015-3f18db00-3e88-11eb-9fd9-e9b28704d790.jpg">
  <br><br><br>

  <li>AES-256으로 암호화된 아이디 패스워드 값을 복호화(패스워드는 SHA-256으로 한번 더 암호화 진행)-> 암호화된 로그인 정보값을 복호화 콘솔로 확인</li>
  <br><br><br>
  <img width ="100%" src="https://user-images.githubusercontent.com/68227318/102124299-6f15ad80-3e8b-11eb-91e8-d430c00685f5.jpg">
</ul>
