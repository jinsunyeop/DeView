CREATE TABLE `user` (
	`user_id`	int auto_increment primary key, -- 유저 번호
	`user_name`	varchar(20)	NOT NULL, -- 유저 이름
	`user_gender`	varchar(2) NOT NULL, -- 유저 성별
	`user_email`	varchar(20)	NOT NULL unique key, -- 유저 이메일
	`user_password`	varchar(20)	NOT NULL, -- 유저 비밀번호
	`user_status`	boolean default false NOT NULL -- 관리자 여부
);

		SELECT * FROM USER ORDER BY user_id;
	
		SELECT * FROM USER WHERE user_id=#{userId};
	
		SELECT user_gender FROM USER WHERE user_id=#{userId};
	
		INSERT INTO USER(user_name,user_gender,user_email,user_password)
		VALUES (#{userName},#{userGender},#{userEmail},#{userPassword})
		<selectKey keyProperty="userId" resultType="int">
			SELECT IFNULL(MAX(user_id),0)+1 FROM USER  
		</selectKey> 
	
		DELETE FROM USER WHERE user_email=#{userEmail};
	
		SELECT * FROM USER WHERE user_email=#{userEmail} 

		UPDATE USER SET user_password=#{userPassword} WHERE user_email=#{userEmail};
		
		

CREATE TABLE `profile` (
	`profile_id`	int	auto_increment primary key, -- 프로필 고유번호
	`user_id`	int	NOT NULL, -- 유저 외래키
	`profile_git`	varchar(30) , -- 깃주소
	`profile_nick`	varchar(20), -- 닉네임
	`profile_img`	varchar(30), -- 프로필 사진명
	 `profile_job` varchar(20) , -- 현재 직무 
	foreign key(user_id) references USER(user_id) on update cascade on delete cascade
);

		SELECT * FROM PROFILE WHERE user_id=#{userId};
	
		select p.* from deview d ,profile p where d.user_id=p.user_id;
	
		SELECT count(*) FROM PROFILE WHERE user_id=#{userId};	

		INSERT INTO PROFILE(user_id,profile_git,profile_nick,profile_img,profile_job)
		VALUES (#{userId},#{profileGit},#{profileNick},#{profileImg},#{profileJob});
	
		UPDATE PROFILE SET profile_git=#{profileGit},profile_nick=#{profileNick},
		profile_img=#{profileImg},profile_job=#{profileJob}  WHERE user_id=#{userId};



CREATE TABLE `deview` (
	`dev_id`	int	NOT NULL auto_increment primary key, -- 서비스 고유번호
	`user_id`	int	NOT NULL, -- 유저 외래키
	`dev_title`	varchar(20) not	NULL, -- 서비스 제목
	`dev_bigcate`	varchar(10)	NOT NULL, -- 주요 언어
	`dev_smallcate`	varchar(10) NOT	NULL, -- 주요 기술 
	`dev_content`	varchar(400) NOT NULL, -- 직무,경험 
	`dev_resp`    int not null default 0, -- 평균 답변시간
	`dev_date`	 datetime DEFAULT NOW(), -- 개설 날짜 
	foreign key(user_id) references USER(user_id) on update cascade on delete cascade
);

		SELECT * FROM DEVIEW WHERE user_id=#{userId}; 
	
		SELECT * FROM DEVIEW ORDER BY dev_id;
	
		SELECT @ROWNUM:=@ROWNUM+1 as ROWNUM, d.* from DEVIEW d,(select @ROWNUM := 0) TMP 
		ORDER BY dev_id DESC LIMIT #{start},#{count};  
	
   		SELECT COUNT(*) FROM DEVIEW;

		INSERT INTO DEVIEW(user_id,dev_title,dev_bigcate,dev_smallcate,dev_content,dev_number)
		VALUES (#{userId},#{devTitle},#{devBigcate},#{devSmallcate},#{devContent},#{devNumber})
		
		UPDATE DEVIEW SET dev_title=#{devTitle},dev_bigcate=#{devBigcate},
		dev_smallcate=#{devSmallcate},dev_content=#{devContent},dev_number=#{devNumber} WHERE user_id=#{userId};
	
		DELETE FROM DEVIEW WHERE dev_id=#{dev_id};	
	
		SELECT * FROM DEVIEW WHERE dev_bigcate=#{devBigcate}; 
	
		SELECT * FROM DEVIEW WHERE dev_title LIKE CONCAT('%',#{devTitle},'%')
	
		SELECT d.* from  PROFILE p ,DEVIEW d where p.profile_nick LIKE CONCAT('%',#{profileNick},'%') and d.user_id=p.user_id;
	
		SELECT d.* from  PROFILE p ,DEVIEW d where ( p.profile_nick LIKE CONCAT('%',#{profileNick},'%') or  d.dev_title LIKE CONCAT('%',#{devTitle},'%')) and d.user_id=p.user_id;



CREATE TABLE `matching` (
	`matching_id`	int auto_increment primary key, -- 매칭 번호
	`matching_request`	int	NOT NULL, -- 매칭 요청한 유저 아이디
	`matching_apply`	int NOT NULL, -- 매칭 응답하는 유저 아이디 
	`matching_status`	boolean default false NOT NULL, -- 매칭 여부
	foreign key(matching_request) references USER(user_id) on update cascade on delete cascade,
	foreign key(matching_apply) references USER(user_id) on update cascade on delete cascade
);

		SELECT * FROM MATCHING WHERE matching_request=#{request} and matching_apply=#{apply};
 
		SELECT * FROM MATCHING WHERE matching_request=#{request} and matching_status=0;
 
		SELECT * FROM MATCHING WHERE matching_apply=#{apply} and matching_status=0;
	
		SELECT * FROM MATCHING WHERE matching_request=#{request} and matching_status =1;
	
		SELECT * FROM MATCHING WHERE matching_apply=#{apply} and matching_status =1;
 
		INSERT INTO MATCHING(matching_request,matching_apply)
		VALUES (#{request},#{apply});
 
		DELETE FROM MATCHING WHERE matching_request=#{request} AND matching_apply = #{apply};
 
		UPDATE MATCHING SET matching_status=1 WHERE matching_request=#{request} AND matching_apply = #{apply};


CREATE TABLE `chat` (
	`chat_id` int auto_increment, -- 채팅방 고유 번호
	`from_id`	int NOT NULL, -- matching apply id
	`to_id`	int	NOT NULL, --  matching request id
	`chat_content`	varchar(400), -- 채팅 내용
    `chat_date` datetime DEFAULT NOW(),
	foreign key(to_id) references USER(user_id) on update cascade on delete cascade,
	foreign key(from_id) references USER(user_id) on update cascade on delete cascade
);


		SELECT * FROM CHAT WHERE ((from_id=#{fromId} and to_id=#{toId}) or (from_id=#{toId} and to_id=#{fromId})) order by chat_date;

		insert into chat(from_id,to_id) values (#{apply},#{request});

		insert into chat(chat_id,from_id,to_id,chat_content) values (#{chatId},#{fromId},#{toId},#{chatContent});


