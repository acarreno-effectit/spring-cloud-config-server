CREATE DATABASE config_server
CREATE SCHEMA properties

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [properties].[PROPERTIES](
	[PROPERTY_KEY] [varchar](225) NOT NULL,
	[APPLICATION] [varchar](225) NOT NULL,
	[VALUE] [varchar](max) NOT NULL,
	[PROFILE] [varchar](128) NOT NULL,
	[LABEL] [varchar](128) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[PROPERTY_KEY] ASC,
	[APPLICATION] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO