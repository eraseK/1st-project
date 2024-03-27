--------------------------------------------------------
--  파일이 생성됨 - 월요일-8월-29-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence MEMBERSHIP_NUM
--------------------------------------------------------

   CREATE SEQUENCE  "MUSIC"."MEMBERSHIP_NUM"  MINVALUE 1 MAXVALUE 10 INCREMENT BY 1 START WITH 3 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence MEMBERSHIP_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "MUSIC"."MEMBERSHIP_SEQ"  MINVALUE 1 MAXVALUE 10 INCREMENT BY 1 START WITH 7 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PLAYLIST_NUM
--------------------------------------------------------

   CREATE SEQUENCE  "MUSIC"."PLAYLIST_NUM"  MINVALUE 1 MAXVALUE 10 INCREMENT BY 1 START WITH 4 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PLAYLIST_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "MUSIC"."PLAYLIST_SEQ"  MINVALUE 1 MAXVALUE 99999 INCREMENT BY 1 START WITH 3 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table LOGINLOG
--------------------------------------------------------

  CREATE TABLE "MUSIC"."LOGINLOG" 
   (	"ID" VARCHAR2(20 BYTE), 
	"INDATE" VARCHAR2(20 BYTE), 
	"OUTDATE" VARCHAR2(20 BYTE)
   ) ;

   COMMENT ON COLUMN "MUSIC"."LOGINLOG"."ID" IS '회원아이디';
   COMMENT ON COLUMN "MUSIC"."LOGINLOG"."INDATE" IS '접속시간';
   COMMENT ON COLUMN "MUSIC"."LOGINLOG"."OUTDATE" IS '로그아웃시간';
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "MUSIC"."MEMBER" 
   (	"NAME" VARCHAR2(30 BYTE), 
	"ID" VARCHAR2(10 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE), 
	"PHONE" VARCHAR2(13 BYTE), 
	"EMAIL" VARCHAR2(30 BYTE), 
	"MEMBERSHIP_ON" VARCHAR2(50 BYTE), 
	"MSTERM" VARCHAR2(20 BYTE)
   ) ;

   COMMENT ON COLUMN "MUSIC"."MEMBER"."NAME" IS '회원이름';
   COMMENT ON COLUMN "MUSIC"."MEMBER"."ID" IS '회원아이디';
   COMMENT ON COLUMN "MUSIC"."MEMBER"."PASSWORD" IS '회원패스워드';
   COMMENT ON COLUMN "MUSIC"."MEMBER"."PHONE" IS '회원폰번호';
   COMMENT ON COLUMN "MUSIC"."MEMBER"."EMAIL" IS '회원이메일';
   COMMENT ON COLUMN "MUSIC"."MEMBER"."MEMBERSHIP_ON" IS '회원멤버쉽가입';
   COMMENT ON COLUMN "MUSIC"."MEMBER"."MSTERM" IS '멤버십기간';
--------------------------------------------------------
--  DDL for Table MEMBERSHIP
--------------------------------------------------------

  CREATE TABLE "MUSIC"."MEMBERSHIP" 
   (	"NUM" NUMBER, 
	"TYPE" VARCHAR2(50 BYTE), 
	"PRICE" NUMBER, 
	"TERM" VARCHAR2(20 BYTE)
   ) ;

   COMMENT ON COLUMN "MUSIC"."MEMBERSHIP"."NUM" IS '번호';
   COMMENT ON COLUMN "MUSIC"."MEMBERSHIP"."TYPE" IS '멤버십 종류';
   COMMENT ON COLUMN "MUSIC"."MEMBERSHIP"."PRICE" IS '가격';
   COMMENT ON COLUMN "MUSIC"."MEMBERSHIP"."TERM" IS '기간';
--------------------------------------------------------
--  DDL for Table PLAYLIST
--------------------------------------------------------

  CREATE TABLE "MUSIC"."PLAYLIST" 
   (	"PL_NUM" NUMBER(*,0), 
	"NAME" VARCHAR2(200 BYTE), 
	"SINGER" VARCHAR2(50 BYTE), 
	"ALBULM" VARCHAR2(20 BYTE), 
	"GENRE" VARCHAR2(20 BYTE), 
	"ID" VARCHAR2(10 BYTE)
   ) ;

   COMMENT ON COLUMN "MUSIC"."PLAYLIST"."PL_NUM" IS '음악번호';
   COMMENT ON COLUMN "MUSIC"."PLAYLIST"."NAME" IS '음악제목';
   COMMENT ON COLUMN "MUSIC"."PLAYLIST"."SINGER" IS '가수';
   COMMENT ON COLUMN "MUSIC"."PLAYLIST"."ALBULM" IS '앨범';
   COMMENT ON COLUMN "MUSIC"."PLAYLIST"."GENRE" IS '장르';
   COMMENT ON COLUMN "MUSIC"."PLAYLIST"."ID" IS '회원아이디';
--------------------------------------------------------
--  DDL for Table SONG
--------------------------------------------------------

  CREATE TABLE "MUSIC"."SONG" 
   (	"SONG_NUM" NUMBER, 
	"NAME" VARCHAR2(100 BYTE), 
	"SINGER" VARCHAR2(50 BYTE), 
	"ALBULM" VARCHAR2(100 BYTE), 
	"GENRE" VARCHAR2(20 BYTE), 
	"FEEL" VARCHAR2(30 BYTE), 
	"LYRICS" VARCHAR2(3000 BYTE)
   ) ;

   COMMENT ON COLUMN "MUSIC"."SONG"."SONG_NUM" IS '음악번호';
   COMMENT ON COLUMN "MUSIC"."SONG"."NAME" IS '음악제목';
   COMMENT ON COLUMN "MUSIC"."SONG"."SINGER" IS '가수';
   COMMENT ON COLUMN "MUSIC"."SONG"."ALBULM" IS '앨범';
   COMMENT ON COLUMN "MUSIC"."SONG"."GENRE" IS '장르';
   COMMENT ON COLUMN "MUSIC"."SONG"."FEEL" IS '분위기';
   COMMENT ON COLUMN "MUSIC"."SONG"."LYRICS" IS '가사';
REM INSERTING into MUSIC.LOGINLOG
SET DEFINE OFF;
REM INSERTING into MUSIC.MEMBER
SET DEFINE OFF;
Insert into MUSIC.MEMBER (NAME,ID,PASSWORD,PHONE,EMAIL,MEMBERSHIP_ON,MSTERM) values ('dd','dd','gg','dd','julooj','무제한 스트리밍','2022-09-28 16:36:01');
Insert into MUSIC.MEMBER (NAME,ID,PASSWORD,PHONE,EMAIL,MEMBERSHIP_ON,MSTERM) values ('ㄹㄹ','ㄹㄹ','ff','ff','ff',null,null);
Insert into MUSIC.MEMBER (NAME,ID,PASSWORD,PHONE,EMAIL,MEMBERSHIP_ON,MSTERM) values ('김지우','jj','jj12','010-2370-9711','julook7@naver.com','무제한 스트리밍','2022-09-28 17:08:31');
Insert into MUSIC.MEMBER (NAME,ID,PASSWORD,PHONE,EMAIL,MEMBERSHIP_ON,MSTERM) values ('김김이','kkl','kk','010-8989','fas@','무제한 스트리밍','2022-09-28 17:18:59');
Insert into MUSIC.MEMBER (NAME,ID,PASSWORD,PHONE,EMAIL,MEMBERSHIP_ON,MSTERM) values ('hh','hh','hh','hh','hh','무제한 스트리밍','2022-09-28 16:54:18');
Insert into MUSIC.MEMBER (NAME,ID,PASSWORD,PHONE,EMAIL,MEMBERSHIP_ON,MSTERM) values ('김지우','jiwoo98','jw123','010-2370-9711','julook7@naver.com',null,null);
REM INSERTING into MUSIC.MEMBERSHIP
SET DEFINE OFF;
Insert into MUSIC.MEMBERSHIP (NUM,TYPE,PRICE,TERM) values (1,'무제한 스트리밍',7900,'1개월');
REM INSERTING into MUSIC.PLAYLIST
SET DEFINE OFF;
Insert into MUSIC.PLAYLIST (PL_NUM,NAME,SINGER,ALBULM,GENRE,ID) values (1,'After LIKE','ive(아이브)','After LIKE','댄스','dd');
Insert into MUSIC.PLAYLIST (PL_NUM,NAME,SINGER,ALBULM,GENRE,ID) values (1,'After LIKE','ive(아이브)','After LIKE','댄스','hh');
Insert into MUSIC.PLAYLIST (PL_NUM,NAME,SINGER,ALBULM,GENRE,ID) values (1,'After LIKE','ive(아이브)','After LIKE','댄스','hh');
Insert into MUSIC.PLAYLIST (PL_NUM,NAME,SINGER,ALBULM,GENRE,ID) values (1,'After LIKE','ive(아이브)','After LIKE','댄스','dd');
REM INSERTING into MUSIC.SONG
SET DEFINE OFF;
Insert into MUSIC.SONG (SONG_NUM,NAME,SINGER,ALBULM,GENRE,FEEL,LYRICS) values (3,'FOREVER1','소녀시대','FOREVER1','K-POP','신나는',null);
Insert into MUSIC.SONG (SONG_NUM,NAME,SINGER,ALBULM,GENRE,FEEL,LYRICS) values (4,'보고싶었어','WSG워너비','WSG워너비 1 집','발라드','잔잔한',null);
Insert into MUSIC.SONG (SONG_NUM,NAME,SINGER,ALBULM,GENRE,FEEL,LYRICS) values (5,'나의X에게','경서','나의X에게','발라드','잔잔한',null);
Insert into MUSIC.SONG (SONG_NUM,NAME,SINGER,ALBULM,GENRE,FEEL,LYRICS) values (6,'취중고백','멜로망스','취중고백','발라드','잔잔한',null);
Insert into MUSIC.SONG (SONG_NUM,NAME,SINGER,ALBULM,GENRE,FEEL,LYRICS) values (7,'열이올라요','선미','열이오른다~','댄스','신나는',null);
Insert into MUSIC.SONG (SONG_NUM,NAME,SINGER,ALBULM,GENRE,FEEL,LYRICS) values (8,'신호등','이무진','신호등','발라드','잔잔한',null);
Insert into MUSIC.SONG (SONG_NUM,NAME,SINGER,ALBULM,GENRE,FEEL,LYRICS) values (9,'뱅뱅뱅','빅뱅','빙그르르르르','힙합','신나는',null);
Insert into MUSIC.SONG (SONG_NUM,NAME,SINGER,ALBULM,GENRE,FEEL,LYRICS) values (10,'전사의후예','HOT','전사다아아아아아','힙합','신나는',null);
Insert into MUSIC.SONG (SONG_NUM,NAME,SINGER,ALBULM,GENRE,FEEL,LYRICS) values (1,'After LIKE','ive(아이브)','After LIKE','댄스','신나는','또 모르지 내 마음이
저 날씨처럼 바뀔지
날 나조차 다 알 수 없으니

그게 뭐가 중요하니
지금 네게 완전히
푹 빠졌단 게 중요한 거지

아마 꿈만 같겠지만 분명 꿈이 아니야
달리 설명할 수 없는 이건 사랑일 거야
방금 내가 말한 감정 감히 의심하지 마
그냥 좋다는 게 아냐 What''s after ''LIKE''?

You and I
It''s more than ''LIKE''
L 다음 또 O 다음 난 yeah
You and I
It''s more than ''LIKE''
What''s after ''LIKE''?
What''s after ''LIKE''?

조심해 두 심장에 핀
새파란 이 불꽃이
저 태양보다 뜨거울 테니

난 저 위로 또 아래로
내 그래프는 폭이 커
Yeah that''s me

두 번 세 번 피곤하게 자꾸 질문하지 마
내 장점이 뭔지 알아? 바로 솔직한 거야
방금 내가 말한 감정 감히 의심하지 마
그냥 좋다는 게 아냐 What''s after ''LIKE''?

You and I
It''s more than ''LIKE''
L 다음 또 O 다음 난 yeah
You and I
It''s more than ''LIKE''
What''s after ''LIKE''?
What''s after ''LIKE''?


What after like 내 맘에 strike
지금 느낀 짜릿함은 마치 tike
LO 다음에 I 그 다음에 VE
여긴 너와 내 space 아무도 막지 못해
나를 보면 눈 깜빡할
시간 조차도 아까울 걸
드디어 만나 반가워
LOVE 사이 놓일 I
(What''s after ''LIKE''?)

You and I
It''s more than ''LIKE''
E 앞 또 V 앞 난 yeah
You and I
It''s more than ''LIKE''
What''s after ''LIKE''?

You and I
It''s more than ''LIKE''
L 다음 또 O 다음 난 yeah
You and I
It''s more than ''LIKE''
What''s after ''LIKE''?
What''s after ''LIKE''?');
Insert into MUSIC.SONG (SONG_NUM,NAME,SINGER,ALBULM,GENRE,FEEL,LYRICS) values (2,'Pink Venom','블랙핑크','Pink Venom','힙합','신나는',null);
--------------------------------------------------------
--  DDL for Index MEMBER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MUSIC"."MEMBER_PK" ON "MUSIC"."MEMBER" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index MEMBER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MUSIC"."MEMBER_PK" ON "MUSIC"."MEMBER" ("ID") 
  ;
--------------------------------------------------------
--  Constraints for Table LOGINLOG
--------------------------------------------------------

  ALTER TABLE "MUSIC"."LOGINLOG" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "MUSIC"."MEMBER" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "MUSIC"."MEMBER" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "MUSIC"."MEMBER" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "MUSIC"."MEMBER" MODIFY ("PHONE" NOT NULL ENABLE);
  ALTER TABLE "MUSIC"."MEMBER" ADD CONSTRAINT "MEMBER_PK" PRIMARY KEY ("ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table MEMBERSHIP
--------------------------------------------------------

  ALTER TABLE "MUSIC"."MEMBERSHIP" MODIFY ("TERM" NOT NULL ENABLE);
  ALTER TABLE "MUSIC"."MEMBERSHIP" MODIFY ("PRICE" NOT NULL ENABLE);
  ALTER TABLE "MUSIC"."MEMBERSHIP" MODIFY ("TYPE" NOT NULL ENABLE);
  ALTER TABLE "MUSIC"."MEMBERSHIP" MODIFY ("NUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PLAYLIST
--------------------------------------------------------

  ALTER TABLE "MUSIC"."PLAYLIST" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "MUSIC"."PLAYLIST" MODIFY ("PL_NUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SONG
--------------------------------------------------------

  ALTER TABLE "MUSIC"."SONG" MODIFY ("ALBULM" NOT NULL ENABLE);
  ALTER TABLE "MUSIC"."SONG" MODIFY ("SINGER" NOT NULL ENABLE);
  ALTER TABLE "MUSIC"."SONG" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "MUSIC"."SONG" MODIFY ("SONG_NUM" NOT NULL ENABLE);
  ALTER TABLE "MUSIC"."SONG" ADD CONSTRAINT "SONG_PK" PRIMARY KEY ("SONG_NUM") DISABLE;
--------------------------------------------------------
--  Ref Constraints for Table PLAYLIST
--------------------------------------------------------

  ALTER TABLE "MUSIC"."PLAYLIST" ADD CONSTRAINT "PLAYLIST" FOREIGN KEY ("ID")
	  REFERENCES "MUSIC"."MEMBER" ("ID") DISABLE;
  ALTER TABLE "MUSIC"."PLAYLIST" ADD CONSTRAINT "PLAYLIST_FK1" FOREIGN KEY ("PL_NUM")
	  REFERENCES "MUSIC"."SONG" ("SONG_NUM") DISABLE;
