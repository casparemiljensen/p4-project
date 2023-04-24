package com.eel

interface Node

data class EelFile(val statements : List<Statement>) : Node

interface Statement : Node
interface Expression : Node
interface Type : Node

object IntType : Type
object DecimalType : Type

interface BinaryExpression : Expression {
    val left: Expression
    val right: Expression
}

