package com.o2.travel_agency.revision.infrastructure.in;

import java.sql.Date;
import java.util.List;

import com.o2.travel_agency.employee.application.ListAllEmployeesUseCase;
import com.o2.travel_agency.employee.domain.entity.Employee;
import com.o2.travel_agency.plane.application.FindPlaneByPlateUseCase;
import com.o2.travel_agency.plane.domain.entity.Plane;
import com.o2.travel_agency.revision.application.CreateRevisionUseCase;
import com.o2.travel_agency.revision.application.DeleteRevisionUseCase;
import com.o2.travel_agency.revision.application.ListAllRevisionsUseCase;
import com.o2.travel_agency.revision.domain.entity.Revision;
import com.o2.travel_agency.revisionEmployee.application.CreateRevisionEmployeeUseCase;
import com.o2.travel_agency.revisionEmployee.domain.entity.RevisionEmployee;
import com.o2.travel_agency.utils.ConsoleUtils;
import com.o2.travel_agency.utils.Menus;
import com.o2.travel_agency.utils.MyScanner;

public class RevisionController {
    private FindPlaneByPlateUseCase findPlaneByPlateUseCase;
    private ListAllEmployeesUseCase listAllEmployeesUseCase;
    private CreateRevisionUseCase createRevisionUseCase;
    private CreateRevisionEmployeeUseCase createRevisionEmployeeUseCase;
    private ListAllRevisionsUseCase listAllRevisionsUseCase;
    private DeleteRevisionUseCase deleteRevisionUseCase;


    public RevisionController(FindPlaneByPlateUseCase findPlaneByPlateUseCase,
            ListAllEmployeesUseCase listAllEmployeesUseCase, CreateRevisionUseCase createRevisionUseCase,
            CreateRevisionEmployeeUseCase createRevisionEmployeeUseCase,
            ListAllRevisionsUseCase listAllRevisionsUseCase, DeleteRevisionUseCase deleteRevisionUseCase) {
        this.findPlaneByPlateUseCase = findPlaneByPlateUseCase;
        this.listAllEmployeesUseCase = listAllEmployeesUseCase;
        this.createRevisionUseCase = createRevisionUseCase;
        this.createRevisionEmployeeUseCase = createRevisionEmployeeUseCase;
        this.listAllRevisionsUseCase = listAllRevisionsUseCase;
        this.deleteRevisionUseCase = deleteRevisionUseCase;
    }

    public void createRevisionLogic() {
        try {
            Date date = ConsoleUtils.validateDate("Type the revision date: ");
            System.out.print("Type the plane plates: ");
            String plates = MyScanner.scanLine();
            Plane plane = findPlaneByPlateUseCase.execute(plates);
            if (plates.length() == 0) {
                throw new Exception("You didn't put plates");
            }
            if (plane == null) {
                throw new Exception("There is no plane with this plates");
            }

            Integer idPlane = plane.getId();
            System.out.print("Type the description: ");
            String description = MyScanner.scanLine();
            if (description.length() == 0) {
                throw new Exception("You didn't put description");
            }
            // employees show all of them in a list
            List<Employee> employees = listAllEmployeesUseCase.execute();
            if (employees.size() == 0) {
                throw new Exception("There is not employees in the database! contact service.");
            }
            // input a validad employee
            int employeePos = Menus.listMenu(employees, "Choose an employee:");
            int employeeId = employees.get(employeePos).getId();

            Revision revision = new Revision(date, idPlane, description);
            Revision revisionDb = createRevisionUseCase.execute(revision);
            if (revisionDb == null) {
                throw new Exception("Unsuccessful  attempt to create a revision");
            }
            // create a relationship between employee and revision
            RevisionEmployee revisionEmployee = new RevisionEmployee(revisionDb.getId(), employeeId);
            RevisionEmployee revisionEmployeeDb = createRevisionEmployeeUseCase.execute(revisionEmployee);
            if (revisionEmployeeDb == null) {
                throw new Exception("Unsuccessful attempt to create a relationship between maintenance and employee.");
            }

            System.out.println("Revision created successfully!");

        } catch (Exception e) {
            System.out.println("Error at creating a maintenance: " + e.getMessage());
        }
    }

    public void deletedRevisionLogic(){
        try {
            // revision show all of them in a list
            List<Revision> revisions =  listAllRevisionsUseCase.execute();
            if (revisions.size() == 0) {
                throw new Exception("There is not revisions in the database! contact service.");
            }
            // input a validad revision
            int revisionPos = Menus.listMenu(revisions, "Choose an revision:");
            Revision revisionUser  =  revisions.get(revisionPos);
            int revisionId = revisionUser.getId();
            int op =  ConsoleUtils.yesOrNo("Are you sure that you want to remove: " + revisionUser.toString() + " ?");
            if(op == 1){
                deleteRevisionUseCase.execute(revisionId);
            }else{
                System.out.println("You have choose to not remove it.");
            }
        } catch (Exception e) {
            System.out.println("Invalid plate.");
        }
    }
}
