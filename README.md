# 📚 Omnivore_Backend_Recent

## 🌟 프로젝트 소개

해당 프로젝트는 프로젝트 팀원이 대학 생활 중 유학생 친구가 식당 간판을 보고 메뉴와 가격 파악을 어려워한다라는 이야기에 영감을 받아 만들어지게 되었습니다. 간판 사진을 촬영하면 사용자의 언어와 통화로 변환된 정보들을 반환하는 서비스입니다. 해당 레포지토리는 어플리케이션의 서버 부분의 소스 코드들 중 사용자의 **최근 방문 식당 정보를 반환**하는 기능을 담고있습니다.

## 💡 사용 기술

- **Spring Boot**: REST API 개발 및 안정적인 백엔드 로직 구현에 사용되었습니다.
- **DynamoDB**: 사용자 정보와 식당 정보를 저장하기 위한 NoSQL 데이터베이스입니다.
- **AWS Translate**: 번역을 위해 사용되었습니다.

## ✨ 주요 기능
- 🔍 **최근 기록 조회**: 사용자가 최근에 방문한 식당을 조회할 수 있는 기능을 제공합니다.
  - 🔄 **통역**: 사용자가 지정한 언어를 기준으로 정보들이 번역되어 제공됩니다.   

## 🚀 설치 및 실행 방법
이 프로젝트를 로컬 환경에서 실행하려면 아래 단계를 따라 주세요.

1. 📦 GitHub에서 리포지토리를 클론합니다.
    ```sh
    git clone https://github.com/Brilly-Bohyun/Omnivore_Backend_Boomark.git
    ```
2. 📂 프로젝트 디렉터리로 이동합니다.
    ```sh
    cd Omnivore_Backend_Boomark
    ```
3. 📦 필요한 종속성을 설치합니다.
    ```sh
    ./gradlew build
    ```
4. ⚙️ 애플리케이션을 실행합니다.
    ```sh
    ./gradlew bootRun
    ```

## 📜 API 문서
Postman을 활용하여 API 엔드포인트를 문서화하고 있습니다. [Postman](https://documenter.getpostman.com/view/20664461/2s9YymG4gV) 을 누르시면 해당 문서를 확인해보실 수 있습니다.
