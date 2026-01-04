package pieces;

import main.Board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Piece {

    public int col, row;
    public int xPos, yPos;
    public boolean isWhite;
    public String name;
    public int value;

    protected BufferedImage sheet;
    protected int sheetScale;
    protected Image sprite;
    protected Board board;

    {
        try {
            sheet = ImageIO.read(
                    Objects.requireNonNull(
                            Piece.class.getResourceAsStream("/pieces.png"),
                            "pieces.png not found in resources folder"
                    )
            );
            sheetScale = sheet.getWidth() / 6;
        } catch (IOException e) {
            throw new RuntimeException("Failed to load pieces.png", e);
        }
    }

    public Piece(Board board) {
        this.board = board;
    }

    public void paint(Graphics2D g2d) {
            g2d.drawImage(sprite, xPos, yPos, null);
        }
    }
