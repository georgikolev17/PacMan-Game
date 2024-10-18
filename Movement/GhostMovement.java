package Movement;

import Common.Coordinates;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


/**
 * Summary: This class implements the logic behind the 2 types of ghost movement: random and smart.
 * A stupid ghost with random movement steps in any direction possible, 
 * regardless of the position of the Pac-Man.
 * A smart ghost with smart steps chases the ghost using Breadth First Search (BFS) algorithm.
 */
public class GhostMovement {
    private int[][] map;

    /**
     * Summary: Creates new instance of GhostMovement.
     * @param map the map in which the ghosts are moving.
     */
    public GhostMovement(int[][] map) {
        super();
        this.map = map;
    }

    /**
     * Summary: The smart step uses Breadth First Search (BFS) 
     * algorithm to alocate the Pac-Man and chase him down.
     * @param ghostRow the ghost's row at the current moment.
     * @param ghostCol the ghost's col at the current moment.
     * @param pacmanRow the pacman's row.
     * @param pacmanCol the pacman's column.
     * @return the next step that the ghost should make on its way to killing the Pac-Man.
     */
    public Coordinates smartStep(int ghostRow, int ghostCol, int pacmanRow, int pacmanCol) {
        boolean[][] checked = new boolean[map.length][map[0].length];
        var previous = new HashMap<Coordinates, Coordinates>();
        // Arrays.fill(checked, false);
        Queue<Coordinates> steps = new LinkedList<Coordinates>();
        
        //These are the possible steps that the ghost can make at the current time
        var possibleSteps = possibleSteps(ghostRow, ghostCol);
        for (Coordinates step : possibleSteps) {
            steps.offer(step);
            previous.put(step, new Coordinates(ghostRow, ghostCol));
            // It is marked which possible steps are checked so they do not get checked again
            checked[step.getRow()][step.getCol()] = true;
        }

        while (!steps.isEmpty()) {
            var currentStep = steps.poll();

            // If the coordinates of the currentStep and pacman's are the same, 
            // the ghost has caught the pacman and the game ends
            if (currentStep.getRow() == pacmanRow && currentStep.getCol() == pacmanCol) {
                break;
            }

            var nextPossibleSteps = possibleSteps(currentStep.getRow(), currentStep.getCol());
            for (Coordinates step : nextPossibleSteps) {
                if (!checked[step.getRow()][step.getCol()]) {
                    // It is marked which possible steps are checked so they do not get 
                    // checked again
                    checked[step.getRow()][step.getCol()] = true;
                    steps.offer(step);
                    previous.put(step, currentStep);
                }
            }
        }
        var backwardsStep = new Coordinates(pacmanRow, pacmanCol);
        if (!previous.containsKey(backwardsStep)) {
            return backwardsStep;
        }
        while (!(previous.get(backwardsStep).getRow() == ghostRow 
            && previous.get(backwardsStep).getCol() == ghostCol)) {
            backwardsStep = previous.get(backwardsStep);
        }

        // The method returns the first step that a ghost needs to make 
        // on his way of chasing the Pac-Man
        return backwardsStep;
    }

    /**
     * Summary: The ghost makes a random step on any possible diretion.
     * @param ghostRow the ghost's row at the current moment.
     * @param ghostCol the ghost's column at the current moment.
     * @return the next step of the ghost.
     */
    public Coordinates randomStep(int ghostRow, int ghostCol) {
        Random rand = new Random();
        var possibleSteps = possibleSteps(ghostRow, ghostCol);

        int index = rand.nextInt(possibleSteps.size());
        return possibleSteps.get(index);
    }

    /**
     * Summary: Gives the ghost's possible steps.
     * @param ghostRow the ghost's row at the current moment.
     * @param ghostCol the ghost's column at the current moment.
     * @return list of the ghost's possible steps.
     */
    private ArrayList<Coordinates> possibleSteps(int ghostRow, int ghostCol) {
        var steps = new ArrayList<Coordinates>();
        if (ghostRow > 0 && map[ghostRow - 1][ghostCol] == 0) {
            steps.add(new Coordinates(ghostRow - 1, ghostCol));
        }
        if (ghostRow < map.length - 1 && map[ghostRow + 1][ghostCol] == 0) {
            steps.add(new Coordinates(ghostRow + 1, ghostCol));
        }
        if (ghostCol > 0 && map[ghostRow][ghostCol - 1] == 0) {
            steps.add(new Coordinates(ghostRow, ghostCol - 1));
        }
        if (ghostCol < map[0].length - 1 && map[ghostRow][ghostCol + 1] == 0) {
            steps.add(new Coordinates(ghostRow, ghostCol + 1));
        }

        return steps;
    }
}
