drop table comment_info;


create table comment_info(
num int(10) not null auto_increment,
content text,
ui_num int(10) not null,
b_num int(10)not null,
reg_date datetime,
foreign key(ui_num) references user_info(num),
foreign key(b_num) references board(num),
primary key(num, ui_num)
)
;
insert into comment_info(content,ui_num,b_num,reg_date)
values('댓글댓글',3 ,33 ,now());


select ci.*, ui.id, ui.name ,b.title
from user_info as ui, board as b, comment_info as ci
where ui.num = b.writer;

select * from user_info;
select * from board;
select * from comment_info;

insert into test(title, content, writer, reg_date)
values('게시물1','내용',1,now())