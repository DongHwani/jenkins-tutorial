
Server : 네이버클라우드 우분투 
### 1. 젠킨스 설치  

#### Step1. openJdk11 설치
```bash
sudo apt-get install openjdk-11-jdk
```

#### Step2. Jenkins 설치
Key 추가
```bash
wget -q -O - https://pkg.jenkins.io/debian/jenkins-ci.org.key | sudo apt-key add -
```
OK가 리턴되면, 서버의 sources list에 Debian패키지 저장소 주소를 추가 
```bash
echo deb https://pkg.jenkins.io/debian-stable binary/ | sudo tee /etc/apt/sources.list.d/jenkins.list
echo "deb https://pkg.jenkins.io/debian-stable binary/" > /etc/apt/sources.list.d/jenkins.list
```
저장소 업데이트 후 Jenkins설치
```bash
sudo apt-get update
```
```bash
sudo apt-get install jenkins
```

#### Step3. Jenkins 시작확인
젠킨스 시작 멍령어
```bash
sudo systemctl start jenkins
```
젠킨스 서버 상태 명령어
```bash
sudo systemctl status jenkins
```
```output
● jenkins.service - LSB: Start Jenkins at boot time
   Loaded: loaded (/etc/init.d/jenkins; generated)
   Active: active (exited) since Tue 2021-05-18 01:24:20 KST; 2min 52s ago
     Docs: man:systemd-sysv-generator(8)
    Tasks: 0 (limit: 1096)
   CGroup: /system.slice/jenkins.service
```

#### Step4. 네이버 클라우드 ACG 설정 
![ACG설정](./image/naver_acg.png)
젠킨스 포트는 디폴트로 8080으로 잡혀있다. 8080포트를 ACG에서 열어준다. 
만약 다른 포트로 설정하였다면 ACG설정에서 해당 포트를 설정해줘야한다. 

#### Step5. 젠킨스 접속 및 플러그인 설치 
최초로 젠킨스 서버로 접속하면 어드민 계정을 초기화하라는 페이지가 나온다.
![unlock-jenkins](./image/unLock-jenkins.png)

```bash
cat /var/lib/jenkins/secrets/initialAdminPassword
```
위의 안내문구처럼 명령어를 실행하여 출력되는 패스워드를 입력한 후 플러그인을 설치한 후 로그인 

### 2. Job 등록 및 Github 연동 
젠킨스에서 Job이란 작업을 의미하며 작업의 최소단위를 일컫는다.    

2.1) Job 등록 
 - 좌측 메뉴의 '새로운 Item' 클릭
![step1](./image/Job_step1.png)
 - Freestyle project 클릭 후 아이템명 입력후 생성
![step2](./image/Job_step2.png)
 - Github SSH 연동  
클라우드 서버에 우선 Git을 설치한다. 
```bash
yum install git 
```



[Refference]  
 - [설치튜토리얼](https://www.digitalocean.com/community/tutorials/how-to-install-jenkins-on-ubuntu-16-04)
 