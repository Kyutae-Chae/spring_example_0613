# spring_example_0613
> 예제 (Spring 사용하기)
> 1. [start.spring.io](http://start.spring.io/) 이용하지 않는 방법
> 2. [start.spring.io](http://start.spring.io/) 이용하고 사용되는 정보들에 대해 정확하게 공부하기
> - DB (MySQL)
>     - 회원 테이블 설계
>     - 게시판 테이블 설계
>     - 회원과 게시판 테이블 연결
> - REST API 만들기
>     - URL 설계
>     - 기능
>         - 글 정보 얻기
>         - 글 등록하기
>         - (+) 글 정보 수정하기
>         - (+) 글 삭제하기
>     - 현재 등록된 모든 게시글 list 받아오기
> - (+) MultipartFile만을 이용해서 간단한 파일 저장 및 파일 관련 테이블 설계 및 구현
> (+)로 되어있는 부분은 선택적으로 진행하시면 됩니다.

## ERD
![image](https://user-images.githubusercontent.com/105179745/173476300-8e1bd311-5476-4ca5-bfdd-4682db64be29.png)  
[DDL.sql](https://github.com/Kyutae-Chae/spring_example_0613/blob/master/src/main/resources/DDL.sql)

## API
|URI   | Method  | 파라메터  | 동작  | 비고  |
|---|---|---|---|---|
|/contents   | Get  | N/A  | 게시물 전체목록 조회 |   |
|/content/{boardId}   | Get  | boardId  | 게시물 조회  |   |
|/content   | Post  | Title, Contents, CreateUser  | 게시물 생성  |   |
|/content/{boardId}   | Patch  | Title, Contents, CreateUser  | 게시물 수정  | 권한처리 없음  |
|/content/{boardId}   | Delete  | boardId  | 게시물 삭제  | 권한처리 없음  |
