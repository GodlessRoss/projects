#projects

controller >
Runner -- ����� ����� � ���������;
JarApp -- ����������� ����� ������������� ����� ������ ���������;
JarMess -- ����������� ����� ����������� (��������, ���������� � �.�.);
JarUsers -- ����������� ����� �������������� (����������).
model >
Aliases -- Enum, �������� �������� �������-����������. ����� ��� ������ JarApp;
Chat -- ����� ���� (����: ���������, ��������, � ����� ������ �������������, ������� ��������� � ����; ��� ������������, ������ ���� ���������);
Data -- "�����������������" ����� (����� ��� ����������� ������ � �������);
Message -- ����� ��������� (����: ����� ���������, �����������, ��������/���, ����������/���, ����� �����������, � ����� ������������, 
������� ���������� ��� ��������� (��� �� ����));
User -- ����� ������������ (����: �����, ������, ���, ������/���, � ����� �������� (�������������, ������� �������), � ����, � ������� �������);
view > 
AllContacts -- �����, ������� ��������� �������� ���� ������������������ 
������������� � �������� ��;
App -- ����������� �����, �� �������� ����������� ������-����������. (����� ��� ��������, � ����� ���������� � ������� �������������� ������ ���� aliace (��� ������ JavApp);
Cabinet -- �����-����������, �������� "����" ���������, ��������� ������������ �������������� � ���������� ������, �������� � ����� "���������";
Contacts -- �����-����������, ��������� ������������ �������������� �� ������ ����������, ����� ��������� ����� ��������, � �������� ��� � ���������� ����������;
Dialog -- �����-����������, ��� ���, � ������� ������������ ������������ �����������;
Logger -- �����-����������, "����" ����� � �������. ����� �������������� ������������ � �������. ����� ��������� ������� � "�����������";
Registration -- �����-����������, "����" ����������� ������������.