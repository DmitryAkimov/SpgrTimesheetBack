## tbProjects
|	Column	|	Type	|	Size	|	Description	|
|---------------|--------------	|---------------|-----------------------|
|**pid**	|	int	|	4	|	ИД P(roject)ID	|
|	title	|	nvarchar	|	200	|	Название проекта	|
|	cipher	|	nchar	|	8	|	Шифр проекта 4-х значный, пример '0596'	|
|	has_budget	|	smallint	|	2	|	Наличие согласованного бюджета=1	|
|	start	|	datetime	|	8	|	Дата начала работ	|
|	finish	|	datetime	|	8	|	Дата окончания работ	|
|	status_id	|	int	|	4	|	НЕ ИСПОЛЬЗУЕТСЯ	|
|	comment	|	nvarchar	|	200	|	Комментарий	|
|	ManagerEid	|	EmployeeID	|	20	|	EID менеджера проекта	|
|	ChiefEid	|	EmployeeID	|	20	|	EID руководителя проекта	|
|	displayname	|	nvarchar	|	200	|	ПРАКТИЧЕСКИ НЕ ИСПОЛЬЗУЕТСЯ Синоним имени для отображения в отчётах	|
|	class	|	int	|	4	|	Аналитическая группа проекта	|
|	ExcelContractCard	|	nvarchar	|	800	|	имя файла карточки договора в формате N:\dddd\dddd\projects.xlsx!Лист	|
|	curator_id	|	int	|	4	|	SID куратора проекта	|
|	beneficiary	|	nvarchar	|	510	|	Название бенефициара проекта строкой	|
|	ref_key	|	uniqueidentifier	|	16	|	ID проекта в 1С	|
|	NotDisplayedStatus	|	int	|	4	|	Не отображать в списке для статус-отчётов	|
|	NotSignedContract	|	int	|	4	|	Признак что договор по активному проекту НЕ подписан	|
|	AgreementNotSigned	|	int	|	4	|	УСТАРЕЛО 	|
|	TimesheetTagsRequired	|	int	|	4	|	Обязательность заполнения тегов в загрузке 0- можно не заполнять, 1-первыый тег, 2-должны быть заполнены оба тега	|
|	TimesheetOnlyMembers	|	int	|	4	|	Только участники проектной группы из 1С могут списывать загрузку на проект	|
|	TimesheetCommentRequired	|	int	|	4	|	При списании загрузки комментарии обязательны	|
|	CompanyStructureId	|	IDRRef	|	16	|	Бизнес-направление из 1С	|
|	ParentId	|	int	|	4	|	"Родительский" проект для консолидации бюджетов	|
|	gid	|	int	|	4	|	УСТАРЕЛО ИД группы (ЦФО)	|
|	code	|	nchar	|	20	|	Мнемонический код проекта типа: SBER, K44 практически НЕ используется	|
|	branch_id	|	int	|	4	|	УСТАРЕЛО ИД офиса	|
|	square	|	int	|	4	|	НЕ ИСПОЛЬЗУЕТСЯ	|
|	inCOE	|	int	|	4	|	УСТАРЕЛО Входит ли проект в КПУ=1	|
|	project_GUID	|	uniqueidentifier	|	16	|	УСТАРЕЛО  НЕ ИСПОЛЬЗУЕТСЯ	|
|	synonym	|	nvarchar	|	2000	|	УСТАРЕЛО НЕ ИСПОЛЬЗУЕТСЯ	|
|	isComplex	|	int	|	4	|	УСТАРЕЛО Признак комплексного проекта=1	|
|	SectorID1	|	int	|	4	|	УСТАРЕЛО сектор	|
|	SectorID2	|	int	|	4	|	УСТАРЕЛО подсектор	|
|	LegalEntityID	|	int	|	4	|	ИД юридичемского лица	|
|	Sector2ID1	|	int	|	4	|	УСТАРЕЛО НОВЫЙ сектор	|
|	Sector2ID2	|	int	|	4	|	УСТАРЕЛО НОВЫЙ подсектор	|
|	manager_id	|	int	|	4	|	УСТАРЕЛО ИД менеджера	|
|	chief_id	|	int	|	4	|	УСТАРЕЛО ИД рукводителя проекта	|
|	ExcelContractCardModifiedDate	|	datetime	|	8	|	NULL	|
|	SearchField	|	nvarchar	|	510	|	NULL	|
|	ExcelBudgetModifiedBy	|	int	|	4	|	NULL	|
|	ExcelBudgetModifiedDate	|	datetime	|	8	|	NULL	|