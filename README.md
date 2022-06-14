# spring_example_0613

## ERD
![image](https://user-images.githubusercontent.com/105179745/173476300-8e1bd311-5476-4ca5-bfdd-4682db64be29.png)

## API
|URI   | Method  | 파라메터  | 동작  | 비고  |
|---|---|---|---|---|
|/contents   | Get  | N/A  | 게시물 전체목록 조회 |   |
|/content/{boardId}   | Get  | boardId  | 게시물 조회  |   |
|/content   | Post  | Title, Contents, CreateUser  | 게시물 생성  |   |
|/content/{boardId}   | Patch  | Title, Contents, CreateUser  | 게시물 수정  | 권한처리 없음  |
|/content/{boardId}   | Delete  | boardId  | 게시물 삭제  | 권한처리 없음  |
