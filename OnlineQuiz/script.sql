USE [OnlineQuiz]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 6/23/2021 8:25:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[userType] [int] NOT NULL,
	[email] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Answer]    Script Date: 6/23/2021 8:25:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Answer](
	[id] [int] NOT NULL,
	[option] [nvarchar](50) NOT NULL,
	[id_question] [int] NOT NULL,
	[check] [bit] NOT NULL,
 CONSTRAINT [PK_Answer] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Questions]    Script Date: 6/23/2021 8:25:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Questions](
	[id] [int] NOT NULL,
	[question] [text] NOT NULL,
	[dateCreated] [varchar](50) NULL,
 CONSTRAINT [PK_questions] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Result]    Script Date: 6/23/2021 8:25:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Result](
	[id_question] [int] NOT NULL,
	[id_answer] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role]    Script Date: 6/23/2021 8:25:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Account] ([username], [password], [userType], [email]) VALUES (N'123', N'123', 1, N'aa@aa.aa')
INSERT [dbo].[Account] ([username], [password], [userType], [email]) VALUES (N'nxduc', N'123', 1, N'nxduc150600@gmail.com')
INSERT [dbo].[Account] ([username], [password], [userType], [email]) VALUES (N'Xuanduc', N'123', 1, N'nxduc@gmail.com')
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (1, N'1', 1, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (2, N'2', 1, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (3, N'3', 1, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (4, N'4', 1, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (5, N'4', 2, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (6, N'5', 2, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (7, N'6', 2, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (8, N'7', 2, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (9, N'3', 3, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (10, N'4', 3, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (11, N'5', 3, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (12, N'6', 3, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (13, N'6', 4, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (14, N'7', 4, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (15, N'8', 4, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (16, N'9', 4, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (17, N'8', 5, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (18, N'9', 5, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (19, N'10', 5, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (20, N'11', 5, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (21, N'12', 6, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (22, N'13', 6, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (23, N'14', 6, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (24, N'15', 6, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (25, N'11', 7, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (26, N'12', 7, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (27, N'13', 7, 0)
INSERT [dbo].[Answer] ([id], [option], [id_question], [check]) VALUES (28, N'14', 7, 0)
INSERT [dbo].[Questions] ([id], [question], [dateCreated]) VALUES (1, N'1+1=', N'1-1-2002')
INSERT [dbo].[Questions] ([id], [question], [dateCreated]) VALUES (2, N'2+3=', N'1-1-2002')
INSERT [dbo].[Questions] ([id], [question], [dateCreated]) VALUES (3, N'3+3=', N'10-10-2003')
INSERT [dbo].[Questions] ([id], [question], [dateCreated]) VALUES (4, N'4+4=', N'1-1-2003')
INSERT [dbo].[Questions] ([id], [question], [dateCreated]) VALUES (5, N'5+5=', N'2-2-2002')
INSERT [dbo].[Questions] ([id], [question], [dateCreated]) VALUES (6, N'6+6=', N'3-3-2002')
INSERT [dbo].[Questions] ([id], [question], [dateCreated]) VALUES (7, N'7+7=', N'2021-06-02')
INSERT [dbo].[Result] ([id_question], [id_answer]) VALUES (1, 2)
INSERT [dbo].[Result] ([id_question], [id_answer]) VALUES (2, 6)
INSERT [dbo].[Result] ([id_question], [id_answer]) VALUES (3, 12)
INSERT [dbo].[Result] ([id_question], [id_answer]) VALUES (4, 15)
INSERT [dbo].[Result] ([id_question], [id_answer]) VALUES (5, 19)
INSERT [dbo].[Result] ([id_question], [id_answer]) VALUES (6, 21)
INSERT [dbo].[Result] ([id_question], [id_answer]) VALUES (7, 28)
SET IDENTITY_INSERT [dbo].[Role] ON 

INSERT [dbo].[Role] ([id], [name]) VALUES (1, N'Student')
INSERT [dbo].[Role] ([id], [name]) VALUES (2, N'Teacher')
SET IDENTITY_INSERT [dbo].[Role] OFF
